package com.test.ws.datamanager.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;

import com.test.ws.constant.ResultCode;
import com.test.ws.datamanager.intrf.LoginDao;
import com.test.ws.entities.Areas;
import com.test.ws.entities.Mandals;
import com.test.ws.entities.Ssp;
import com.test.ws.entities.Users;
import com.test.ws.entities.UsersFieldData;
import com.test.ws.exception.BusinessException;
import com.test.ws.exception.CommandException;
import com.test.ws.exception.InfrastructureException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.LoginResponse;
import com.test.ws.requestobject.Response;
import com.test.ws.utils.HibernateUtil;
import com.test.ws.utils.TokenGenerator;

public class LoginDaoImpl implements LoginDao {

	public static final String CLASS = LoginDaoImpl.class.getName();
	public static final String MODULE = LoginDaoImpl.class.getSimpleName();
	
    public static  final String userDataQuery = 
    		"select u.id,u.role_id,u.user_name," +
            "u.username,u.email,u.password,u.phone," +
            "u.whatsapp_number,u.email_verified,u.birth_date" +
            ",u.user_image,u.latitude,u.longitude,u.address," +
            "u.auth_token,u.relationship_status,u.created_at," +
            "u.updated_at,u.status,u.device_type,u.device_token," +
            "u.badge_count,ur.role_name,ar.area_title,m.mandal_title from users u " +
            "left join user_roles ur on ur.id=u.role_id left join areas ar on ar.area_id=u.area_id " +
            "left join mandals m on m.mandal_id = u.mandal_id";

    @Override
    public LoginResponse validateLogin(String email, String password) throws CommandException {

        Long user_id = 0l;
        List<Object[]> list = null;
        String queryString = "";
        Users user = new Users();
        LoginResponse loginResponse = new LoginResponse();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            String token = TokenGenerator.uniqueUUID();

            queryString = "select * from users where email='" + email + "' and password='" + password + "'";
            Query query = session.createSQLQuery(queryString);
            list = query.list();

            if (!list.isEmpty()) {
                for (Object[] o : list) {
                    user_id = ((BigInteger) o[0]).longValue();
                }

                queryString = "update users set auth_token='" + token + "',updated_at='" + getFormatedDate() + "' where id='" + user_id + "'";
                query = session.createSQLQuery(queryString);
                query.executeUpdate();

                queryString = "select u.first_name,u.middle_name,u.last_name,email,u.auth_token,ur.role_name,ur.id from users u left join user_roles ur on ur.id=u.role_id  where u.id='" + user_id + "'";
                query = session.createSQLQuery(queryString);
                List<Object[]> testuser = query.list();

                for (Object[] ob : testuser) {
                    loginResponse.setFirstName((String) ob[0]);
                    loginResponse.setMiddleName((String) ob[1]);
                    loginResponse.setLastName((String) ob[2]);
                    loginResponse.setEmail((String) ob[3]);
                    loginResponse.setToken((String) ob[4]);
                    loginResponse.setuTypeName((String) ob[5]);
                    loginResponse.setuType(String.valueOf((Integer) ob[6]));
                    loginResponse.setuId(String.valueOf(user_id));
                }
                TokenGenerator.tokenMap.put(loginResponse.getToken(),loginResponse.getToken());
            } else {
                return null;
            }
            tx.commit();
        } catch (InfrastructureException ex) {
            tx.rollback();
            throw new CommandException(ex);

        } catch (BusinessException ex) {
            throw new CommandException(ex);
        } finally {
            session.close();
        }
        return loginResponse;
    }

    private Timestamp getFormatedDate() {
        java.util.Date date = new java.util.Date();
        return new Timestamp(date.getTime());
    }

    @Override
    public List<UsersFieldData> getUserContactList() throws CommandException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = null;
        UsersFieldData usersFieldData = new UsersFieldData();
        List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

        try {
            Query crt = session.createSQLQuery(userDataQuery);
            list = crt.list();
            usersFieldDataList = fillUserTablePojo(list);

        } catch (InfrastructureException ex) {
            throw new InfrastructureException(ex);
        } catch (BusinessException ex) {
            throw new BusinessException(ex);
        } finally {
            session.close();
        }
        return usersFieldDataList;
    }

    @Override
    public List<UsersFieldData> getBirthday(String cakeId) throws CommandException {

        String queryString = "";
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = null;
        UsersFieldData usersFieldData = null;
        List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

        /**
         *  0 = today's
         *  1 =  Week
         *  2 = 1 Months
         *  3 = 3 Months
         *  4 = 6 months
         */
        try {
            Long myBirthdayDigit = Long.parseLong(cakeId);
            if (myBirthdayDigit == 0) {
                queryString = userDataQuery + " WHERE u.birth_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 0 DAY) ORDER BY u.first_name";
            } else if (myBirthdayDigit == 1) {
                queryString = userDataQuery + " WHERE u.birth_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY) ORDER BY u.birth_date";
            } else if (myBirthdayDigit == 2) {
                queryString = userDataQuery + " WHERE u.birth_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH) ORDER BY u.birth_date";
            } else if (myBirthdayDigit == 3) {
                queryString = userDataQuery + " WHERE u.birth_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 3 MONTH) ORDER BY u.birth_date";
            } else if (myBirthdayDigit == 4) {
                queryString = userDataQuery + " WHERE u.birth_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 6 MONTH) ORDER BY u.birth_date";
            }
            Query queryNew = session.createSQLQuery(queryString);
            list = queryNew.list();
            usersFieldDataList = fillUserTablePojo(list);

        } catch (InfrastructureException ex) {
            throw new InfrastructureException(ex);
        } catch (BusinessException ex) {
            throw new BusinessException(ex);
        } finally {
            session.close();
        }
        return usersFieldDataList;
    }

    @Override
    public Response getSSP() {
        String queryString = "";
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Ssp> sspList = new ArrayList<Ssp>();
        try {
            queryString = "select ssp_id,ssp_title from ssp";
            Query query = session.createSQLQuery(queryString);
            List<Object[]> list = query.list();

            for (Object[] newList : list) {
                Ssp ssp = new Ssp();
                ssp.setSspId((Integer) newList[0]);
                ssp.setSspTitle((String) newList[1]);
                sspList.add(ssp);
            }

        } catch (Exception e) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
        } finally {
            session.close();
        }
        return new Response(ResultCode.SUCCESS_200.code, ResultCode.SUCCESS_200.name, null, null, sspList);
    }

    @Override
    public Response getArea() {

        String queryString = "";
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Areas> areasArrayList = new ArrayList<Areas>();

        try {
            queryString = "select area_id,area_title from areas";
            Query query = session.createSQLQuery(queryString);
            List<Object[]> list = query.list();

            for (Object[] newList : list) {
                Areas areas = new Areas();
                areas.setAreaId((Integer) newList[0]);
                areas.setAreaTitle((String) newList[1]);
                areasArrayList.add(areas);
            }

        } catch (Exception e) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
        } finally {
            session.close();
        }
        return new Response(ResultCode.SUCCESS_200.code, ResultCode.SUCCESS_200.name, null, null, areasArrayList);
    }

    @Override
    public Response getManadal() {
        String queryString = "";
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mandals> mandalsArrayList = new ArrayList<Mandals>();

        try {
            queryString = "select mandal_id,mandal_title from mandals";
            Query query = session.createSQLQuery(queryString);
            List<Object[]> list = query.list();

            for (Object[] newList : list) {
                Mandals mandals = new Mandals();
                mandals.setMandalId((Integer) newList[0]);
                mandals.setMandalTitle((String) newList[1]);
                mandalsArrayList.add(mandals);
            }

        } catch (Exception e) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
        } finally {
            session.close();
        }
        return new Response(ResultCode.SUCCESS_200.code, ResultCode.SUCCESS_200.name, null, null, mandalsArrayList);
    }

    public Object setObject(Object obj) {

        if (obj instanceof BigInteger) {
            return String.valueOf(((BigInteger) obj).intValue());
        } else if (obj instanceof BigDecimal) {
            return String.valueOf(((BigDecimal) obj).intValue());
        } else if (obj instanceof Timestamp) {
            return new Date(((Timestamp) obj).getTime());
        }
        return obj;
    }

    private List<UsersFieldData> fillUserTablePojo(List<Object[]> list){
        List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();
        for (Object[] obj : list) {
            UsersFieldData usersFieldData = new UsersFieldData();
            usersFieldData.setId(((BigInteger) obj[0]).longValue());
            usersFieldData.setRole_id((Integer) obj[1]);
            usersFieldData.setUser_name((String) obj[2]);
            usersFieldData.setUsername((String) obj[3]);
            usersFieldData.setEmail((String) obj[4]);
            usersFieldData.setPassword((String) obj[5]);
            usersFieldData.setPhone((String) obj[6]);
            usersFieldData.setWhatsapp_number((String) obj[7]);
            usersFieldData.setEmail_verified((Boolean) obj[8]);
            usersFieldData.setBirth_date((Date) setObject(obj[9]));
            usersFieldData.setUser_image((String) obj[10]);
            usersFieldData.setLatitude(((BigDecimal) obj[11]).doubleValue());
            usersFieldData.setLongitude(((BigDecimal) obj[12]).doubleValue());
            usersFieldData.setAddress((String) obj[13]);
            usersFieldData.setAuth_token((String) obj[14]);
            usersFieldData.setRelationship_status((String) obj[15]);
            usersFieldData.setCreated_at((Date) setObject(obj[16]));
            usersFieldData.setUpdated_at((Date) setObject(obj[17]));
            usersFieldData.setStatus((Boolean) obj[18]);
            usersFieldData.setDevice_type((Integer) obj[19]);
            usersFieldData.setDevice_token((String) obj[20]);
            usersFieldData.setBadge_count((Integer) obj[21]);
            usersFieldData.setRole_name((String) obj[22]);
            usersFieldData.setArea_title((String) obj[23]);
            usersFieldData.setMandal_title((String) obj[24]);
            usersFieldDataList.add(usersFieldData);
        }
        return usersFieldDataList;
    }

    @Override
    public Response doCreateSabha() {
        String queryString = "";
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mandals> mandalsArrayList = new ArrayList<Mandals>();

        try {
            queryString = "insert into sabhas values(3,'parasabha',2,'2001-02-10','17:00:00','19:00:00',0,'2121121','1212121')";
            Query query = session.createSQLQuery(queryString);
            query.executeUpdate();

        } catch (Exception e) {
            return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null, null);
        } finally {
            session.close();
        }
        return new Response(ResultCode.SUCCESS_200.code, "Sabha successfully created!", null, null, null);
    }

    @Override
    public Response getSabhaDetails() {
        return null;
    }

	@Override
	public Response uploadDataByExcel(List<Object[]> list) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		PreparedStatement ps = null;
		Statement st = null;
		int failedDataConunt = 0;
		int successDataCount = 0;

		try {
			SessionImplementor sessImpl = (SessionImplementor) session;
			Connection connection = sessImpl.connection();
			connection.setAutoCommit(true);
			st = connection.createStatement();

			// batch insert
			String sql = "INSERT INTO USERS(ROLE_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,USERNAME,EMAIL,PASSWORD,PHONE,WHATSAPP_NUMBER,EMAIL_VERIFIED,BIRTH_DATE,USER_IMAGE,LATITUDE,LONGITUDE,ADDRESS,AREA_ID,MANDAL_ID,AUTH_TOKEN,RELATIONSHIP_STATUS,CREATED_AT,UPDATED_AT,STATUS,DEVICE_TYPE,DEVICE_TOKEN,BADGE_COUNT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			int i =0 ;
			for (Object[] newData : list) {
				if (newData != null) {
					
					if(i == 0){
						i++;
						continue;
					}
					ps.setInt(1, 3);
					
					if("".equals(newData[0])) break;
					ps.setString(2, (String)newData[0]);
					ps.setString(3, "");
					ps.setString(4, "");
					ps.setString(5, ((String)newData[0]).toLowerCase());
					ps.setString(6, ((String)newData[0]).toLowerCase() + "@gmail.com");
					ps.setString(7, ((String)newData[0]).toLowerCase());
					
					String phno = String.valueOf((String)newData[2]).replace("+", "");
					ps.setString(8, phno);
					
					String Whatsapp = String.valueOf((String)newData[3]).replace("+", "");
					ps.setString(9, Whatsapp);
					ps.setInt(10, 1);
					
					String str = (String)newData[5];
					if(!"".equals(str)){
						ps.setTimestamp(11,simpleDateFormat(newData[5]));	
					}
					ps.setInt(12, 0);
					ps.setInt(13, 0);
					ps.setInt(14, 0);
					ps.setString(15, (String)newData[6]);
					ps.setInt(16, 5);
					ps.setInt(17, 6);
					ps.setString(18, TokenGenerator.uniqueUUID());
					ps.setInt(19, 0);
					ps.setTimestamp(20, getFormatedDate());
					ps.setTimestamp(21, getFormatedDate());
					ps.setInt(22, 0);
					ps.setInt(23, 0);
					ps.setInt(24, 0);
					ps.setInt(25, 0);
					
					ps.addBatch();
					successDataCount++;
					if (successDataCount % 100 == 0) {
						ps.executeBatch();
					}
				}
			}
			ps.executeBatch();
		} catch (BatchUpdateException e) {
			int[] updateCounts = e.getUpdateCounts();
			Logger.logDebug(MODULE, "UpdateCounts :" + updateCounts.length);
			throw new BusinessException("Upload Translation Mapping Data Failed, Reason " + e.getMessage());
		} catch (HibernateException hExp) {
			throw new BusinessException(hExp.getMessage(), hExp);
		} catch (Exception exp) {
			throw new BusinessException(exp.getMessage(), exp);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (st != null)
					st.close();
			} catch (SQLException sExp) {
				throw new BusinessException(sExp.getMessage(), sExp);
			}
		}
		return new Response(ResultCode.SUCCESS_200.code,ResultCode.SUCCESS_200.name,"Inserted Record:" +successDataCount + "\nSkipped Record:" +failedDataConunt,null,null);
	}
	
    private Timestamp simpleDateFormat(Object obj) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Timestamp ts = new Timestamp(((java.util.Date)df.parse((String)obj)).getTime());
		return ts;
	}

	@Override
	public List<UsersFieldData> getMandalYuvakList(Integer mandal_id) {

		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
        List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

		try {
			queryString =userDataQuery + " WHERE U.MANDAL_ID="+mandal_id;
			Query query = session.createSQLQuery(queryString);
            usersFieldDataList = fillUserTablePojo(query.list());
			
		}catch (InfrastructureException ex) {
            throw new InfrastructureException(ex);
        } catch (BusinessException ex) {
            throw new BusinessException(ex);
        } finally {
            session.close();
        }
		return usersFieldDataList;
	}

	@Override
	public List<UsersFieldData> getYuvakProfile(Integer user_id) {
		
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
        List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

		try {
			queryString =userDataQuery + " WHERE U.ID="+user_id;
			Query query = session.createSQLQuery(queryString);
            usersFieldDataList = fillUserTablePojo(query.list());
			
		}catch (InfrastructureException ex) {
            throw new InfrastructureException(ex);
        } catch (BusinessException ex) {
            throw new BusinessException(ex);
        } finally {
            session.close();
        }
		return usersFieldDataList;
	}
}
