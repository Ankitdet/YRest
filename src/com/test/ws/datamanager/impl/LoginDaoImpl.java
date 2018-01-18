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
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;

import com.test.ws.constant.ResultCode;
import com.test.ws.datamanager.intrf.LoginDao;
import com.test.ws.entities.Areas;
import com.test.ws.entities.AttendanceRequest;
import com.test.ws.entities.CreateSabhaData;
import com.test.ws.entities.Mandals;
import com.test.ws.entities.SabhaData;
import com.test.ws.entities.Ssp;
import com.test.ws.entities.UsersFieldData;
import com.test.ws.entities.YuAttendance;
import com.test.ws.exception.BusinessException;
import com.test.ws.exception.CommandException;
import com.test.ws.exception.InfrastructureException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.LoginResponse;
import com.test.ws.requestobject.Response;
import com.test.ws.utils.AkdmUtils;
import com.test.ws.utils.HibernateUtil;
import com.test.ws.utils.TokenGenerator;

public class LoginDaoImpl implements LoginDao {

	public static final String CLASS = LoginDaoImpl.class.getName();
	public static final String MODULE = LoginDaoImpl.class.getSimpleName();
	
    public static  final String userDataQuery = 
    		"select u.id,u.role_id,u.user_name," +
            "u.email,u.password,u.phone," +
            "u.whatsapp_number,u.email_verified,u.birth_date" +
            ",u.user_image,u.latitude,u.longitude,u.address," +
            "u.auth_token,u.relationship_status,u.created_at," +
            "u.updated_at,u.status,u.device_type,u.device_token," +
            "u.badge_count,ur.role_name,ar.area_title,m.mandal_title from users u " +
            "left join user_roles ur on ur.id=u.role_id left join areas ar on ar.area_id=u.area_id " +
            "left join mandals m on m.mandal_id = u.mandal_id";

    @Override
    public LoginResponse validateLogin(String email, String password) throws CommandException {

        Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
        Long user_id = 0l;
        List<Object[]> list = null;
        String queryString = "";
        LoginResponse loginResponse = new LoginResponse();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {


            queryString = "select * from users where email='" + email + "' and password='" + password + "'";
            Query query = session.createSQLQuery(queryString);
            list = query.list();

            if (!list.isEmpty()) {
                for (Object[] o : list) {
                    user_id = ((BigInteger) o[0]).longValue();
                }

                queryString = "update users set auth_token='" + TokenGenerator.uniqueUUID() + "',updated_at='" + AkdmUtils.getFormatedDate() + "' where id='" + user_id + "'";
                query = session.createSQLQuery(queryString);
                query.executeUpdate();

                queryString = "select u.user_name,email,u.auth_token,ur.role_name,ur.id from users u left join user_roles ur on ur.id=u.role_id  where u.id='" + user_id + "'";
                query = session.createSQLQuery(queryString);
                List<Object[]> testuser = query.list();

                for (Object[] ob : testuser) {
                    loginResponse.setUser_name((String) ob[0]);
                    loginResponse.setEmail((String) ob[1]);
                    loginResponse.setToken((String) ob[2]);
                    loginResponse.setuTypeName((String) ob[3]);
                    loginResponse.setuType(String.valueOf((Integer) ob[4]));
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

    @Override
    public List<UsersFieldData> getUserContactList() throws CommandException {

    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = null;
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

    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
        String queryString = "";
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = null;
        List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

		try {
            Long myBirthdayDigit = Long.parseLong(cakeId);
            if (myBirthdayDigit == 0) {
                queryString = userDataQuery + " WHERE "+getBirthFilterQuery(cakeId)+" ORDER BY u.USER_NAME";
            } else  {
                queryString = userDataQuery + " WHERE "+getBirthFilterQuery(cakeId)+" ORDER BY MONTH("+com.test.ws.constant.Constants.BIRTH_DATE+")";
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

    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
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

    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
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
    	
    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
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

    private List<UsersFieldData> fillUserTablePojo(List<Object[]> list){
    	
        Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);

        List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();
        for (Object[] obj : list) {
            UsersFieldData usersFieldData = new UsersFieldData();
            usersFieldData.setId(((BigInteger) obj[0]).longValue());
            usersFieldData.setRole_id((Integer) obj[1]);
            usersFieldData.setUser_name((String) obj[2]);
            usersFieldData.setEmail((String) obj[3]);
            usersFieldData.setPassword((String) obj[4]);
            usersFieldData.setPhone((String) obj[5]);
            usersFieldData.setWhatsapp_number((String) obj[6]);
            usersFieldData.setEmail_verified((Boolean) obj[7]);
            usersFieldData.setBirth_date((Date) AkdmUtils.setObject(obj[8]));
            usersFieldData.setUser_image((String) obj[9]);
            usersFieldData.setLatitude(((BigDecimal) obj[10]).doubleValue());
            usersFieldData.setLongitude(((BigDecimal) obj[11]).doubleValue());
            usersFieldData.setAddress((String) obj[12]);
            usersFieldData.setAuth_token((String) obj[13]);
            usersFieldData.setRelationship_status((String) obj[14]);
            usersFieldData.setCreated_at((Date) AkdmUtils.setObject(obj[15]));
            usersFieldData.setUpdated_at((Date) AkdmUtils.setObject(obj[16]));
            usersFieldData.setStatus((Boolean) obj[17]);
            usersFieldData.setDevice_type((Integer) obj[18]);
            usersFieldData.setDevice_token((String) obj[19]);
            usersFieldData.setBadge_count((Integer) obj[20]);
            usersFieldData.setRole_name((String) obj[21]);
            usersFieldData.setArea_title((String) obj[22]);
            usersFieldData.setMandal_title((String) obj[23]);
            usersFieldDataList.add(usersFieldData);
        }
        return usersFieldDataList;
    }

    @Override
    public Response doCreateSabha() {
    	
    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
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

    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
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
			String sql = "INSERT INTO users(ROLE_ID,USER_NAME,USER_UNIQUEID,EMAIL,PASSWORD,PHONE,WHATSAPP_NUMBER,EMAIL_VERIFIED,BIRTH_DATE,USER_IMAGE,LATITUDE,LONGITUDE,ADDRESS,AREA_ID,MANDAL_ID,AUTH_TOKEN,RELATIONSHIP_STATUS,CREATED_AT,UPDATED_AT,STATUS,DEVICE_TYPE,DEVICE_TOKEN,BADGE_COUNT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
					ps.setString(3, (String)newData[0] + "_Y_");
					ps.setString(4, ((String)newData[0]).toLowerCase() + "@gmail.com");
					ps.setString(5, ((String)newData[0]).toLowerCase());
					
					String phno = String.valueOf((String)newData[2]).replace("+", "");
					ps.setString(6, phno);
					
					String Whatsapp = String.valueOf((String)newData[3]).replace("+", "");
					ps.setString(7, Whatsapp);
					ps.setInt(8,1);
					
					String str = (String)newData[5];
					if(!"".equals(str)){
						ps.setDate(9,simpleDateFormat(newData[5]));	
					}
					ps.setInt(10, 0);
					ps.setInt(11, 0);
					ps.setInt(12, 0);
					ps.setString(13, (String)newData[6]);
					ps.setInt(14, 5);
					ps.setInt(15, 6);
					ps.setString(16, TokenGenerator.uniqueUUID());
					ps.setInt(17, 0);
					ps.setTimestamp(18, AkdmUtils.getFormatedDate());
					ps.setTimestamp(19, AkdmUtils.getFormatedDate());
					ps.setInt(20, 0);
					ps.setInt(21, 0);
					ps.setInt(22, 0);
					ps.setInt(23, 0);
					
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
			Logger.logError(MODULE, hExp.getMessage());
		} catch (Exception exp) {
			Logger.logError(MODULE, exp.getMessage());
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
	
    private Date simpleDateFormat(Object obj) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dt = new Date((df.parse((String)obj)).getTime());
		return dt;
	}

	@Override
	public List<UsersFieldData> getMandalYuvakList(Integer mandal_id) {

    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
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
    	
		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
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

	@Override
	public List<SabhaData> getSabhaList() {
		
    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
        List<SabhaData> sabhaList = new ArrayList<SabhaData>();

		try {
			queryString = "SELECT SABHA_TITLE,DATE,SABHA_ID FROM SABHAS";
			Query query = session.createSQLQuery(queryString);
			List<Object[]> list = query.list();
 			
			for(Object[] obj : list){
				SabhaData sabhaData = new SabhaData();
				sabhaData.setSabha_title((String)obj[0]);
				sabhaData.setSabha_date((Date)obj[1]);
				sabhaData.setMandal_id((Integer)obj[2]);
				sabhaList.add(sabhaData);
			}
		}catch (InfrastructureException ex) {
            throw new InfrastructureException(ex);
        } catch (BusinessException ex) {
            throw new BusinessException(ex);
        } finally {
            session.close();
        }
		return sabhaList;
	}

	@Override
	public List<Mandals> getSabhaMandalList(Integer sabha_id) {
		
    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mandals> mandalList = new ArrayList<Mandals>();

		try {
			queryString = "SELECT MANDAL_ID,MANDAL_TITLE FROM MANDALS WHERE MANDAL_ID = (SELECT MANDAL_ID FROM SABHAS WHERE SABHA_ID="+sabha_id+")";
			Query query = session.createSQLQuery(queryString);
			List<Object[]> list = query.list();
 			
			for(Object[] obj : list){
				Mandals mandals = new Mandals();
				mandals.setMandalId((Integer)obj[0]);
				mandals.setMandalTitle((String)obj[1]);
				mandalList.add(mandals);
			}
		}catch (InfrastructureException ex) {
            throw new InfrastructureException(ex);
        } catch (BusinessException ex) {
            throw new BusinessException(ex);
        } finally {
            session.close();
        }
		return mandalList;
	}

	@Override
	public List<CreateSabhaData> getSabhaYuvakList(Integer sabha_id, Integer mandal_id) {
		
    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
        List<CreateSabhaData> userSabhaList = new ArrayList<CreateSabhaData>();
        
        try {
			queryString = "select id,user_name,user_uniqueid from users where mandal_id="+mandal_id+"" ;
			Query query = session.createSQLQuery(queryString);
			List<Object[]> list = query.list();

			for(Object[] object : list){
				CreateSabhaData createSabhaData = new CreateSabhaData();
				createSabhaData.setUser_id(((BigInteger) object[0]).longValue());
				createSabhaData.setUser_name((String)object[1]);
				createSabhaData.setUser_uniqueid((String)object[2]);
				createSabhaData.setIs_Attended(false);
				userSabhaList.add(createSabhaData);
			}
			
        }catch (InfrastructureException ex) {
            throw new InfrastructureException(ex);
        } catch (BusinessException ex) {
            throw new BusinessException(ex);
        } finally {
            session.close();
        }
		return userSabhaList;
	}

	@Override
	public Response createYuvakSabhaAttendance(AttendanceRequest request) {

    	Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
		Session session = HibernateUtil.getSessionFactory().openSession();
		PreparedStatement ps = null;
		Statement st = null;
		int count = 0;

		try {
			SessionImplementor sessImpl = (SessionImplementor) session;
			Connection connection = sessImpl.connection();
			connection.setAutoCommit(true);
			st = connection.createStatement();

			String sql = "INSERT INTO YUVA_ATTENDANCE(SABHA_ID,MANDAL_ID,USER_ID,IS_ATTENDED) VALUES(?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, request.getSabha_id());
			ps.setLong(2, request.getMandal_id());
			for (YuAttendance yAttendance : request.getListOfAttendance()) {
				ps.setLong(3, yAttendance.getYuvak_id());
				ps.setBoolean(4, yAttendance.isIs_attended());
				ps.addBatch();
				if (count % 100 == 0) {
					ps.executeBatch();
				}
				count++;
			}
			ps.executeBatch();
		} catch (BatchUpdateException e) {
			int[] updateCounts = e.getUpdateCounts();
			Logger.logDebug(MODULE, "UpdateCounts :" + updateCounts.length);
			throw new BusinessException(
					"Upload Translation Mapping Data Failed, Reason "
							+ e.getMessage());
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
		return new Response(ResultCode.SUCCESS_200.code,
				ResultCode.SUCCESS_200.name, "Insert record successfully",
				null, null);
	}
	
	private String getBirthFilterQuery(String id){

		Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);

		  /**
         *  default 0 = today's
         *  if id 1 = 1 Week
         *  if id 2 = 1 Months
         *  if id 3 = 3 Months
         *  if id 4 = 6 months
         */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = dateFormat.parse(dateFormat.format(new java.util.Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int start_month = c.get(Calendar.MONTH);
		int start_day =c.get(Calendar.DATE);
		int end_month = 0;
		int end_day = 0;

		StringBuffer sb = new StringBuffer();
		
		switch (id) {
		case "1":
			// Next 7 days
			c.add(Calendar.DATE, 7); 
			end_day = c.get(Calendar.DATE);
			end_month = c.get(Calendar.MONTH);
			
			if(start_month == end_month){
				sb.append(++start_month);
			}else{
				sb.append(++start_month).append(",").append(++end_month);
			}
			break;
			
		case "2" :
			// Next 1 month
			c.add(Calendar.MONTH, 1); 
			end_day = c.get(Calendar.DATE);
			end_month = c.get(Calendar.MONTH);
			sb.append(++start_month).append(",").append(++end_month);
			break;
		
		case "3" :
			// Next 3 month
			c.add(Calendar.MONTH, 3); 
			end_day = c.get(Calendar.DATE);
			end_month = c.get(Calendar.MONTH);
			
			for(int i = 1;i<=4;i++){
				if(start_month == 12) {
					start_month = 1;
					sb.append(start_month).append(",");
					continue;
				}
				sb.append(++start_month).append(",");
			}
			sb.replace(sb.length()-1,sb.length(), "");
			
			break;
		
		case "4" :
			
			// Next 6 month
			c.add(Calendar.MONTH, 6); 
			end_day = c.get(Calendar.DATE);
			end_month = c.get(Calendar.MONTH);
			for(int i = 1;i<= 7;i++){
				if(start_month == 12) {
					start_month = 1;
					sb.append(start_month).append(",");
					continue;
				}
				sb.append(++start_month).append(",");
			}
			sb.replace(sb.length()-1,sb.length(), "");
			break;
			
		default:
			// current date
			end_day = start_day;
			sb.append(++start_month);
			break;
		}
		return "MONTH("+com.test.ws.constant.Constants.BIRTH_DATE+") In ("+sb+") and DAY("+com.test.ws.constant.Constants.BIRTH_DATE+")>="+start_day+" and DAY("+com.test.ws.constant.Constants.BIRTH_DATE+")<="+end_day+"";
	}
}
