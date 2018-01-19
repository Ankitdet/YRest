package com.test.ws.datamanager.impl;

import java.math.BigInteger;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.test.ws.datamanager.intrf.UserDao;
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

public class UserDaoImpl implements UserDao {

	public static final String CLASS = UserDaoImpl.class.getName();
	public static final String MODULE = UserDaoImpl.class.getSimpleName();
	
	/**
	 * Initialize counter variable for get COLUMN values
	 * @see AkdmUtils#getMethodName()
	 */
	public static int counter ;
	
    public static  final String userDataQuery = 
    		"select u.id,u.role_id,u.user_name," +
            "u.email,u.password,u.phone," +
            "u.whatsapp_number,u.email_verified,u.birth_date" +
            ",u.user_image,u.latitude,u.longitude,u.address," +
            "u.auth_token,u.relationship_status,u.created_at," +
            "u.updated_at,u.status,u.device_type,u.device_token," +
            "u.badge_count,ur.role_name,ar.area_title,m.mandal_title from users u " +
            "left join user_roles ur on ur.id=u.role_id left join areas ar on ar.area_id=u.area_id " +
            "left join mandals m on m.mandal_id = u.mandal_id ";

    @Override
    public List<UsersFieldData> validateLogin(String email, String password) throws CommandException {
        Logger.logInfo(MODULE, "Method called " +AkdmUtils.getMethodName()+" of " + CLASS);
        Long user_id = 0l;
        List<Object[]> list = null;
        String queryString = "";
        List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();
        
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

                queryString = "update users set auth_token='" + token + "',updated_at='" + AkdmUtils.getFormatedDate() + "' where id='" + user_id + "'";
                query = session.createSQLQuery(queryString);
                query.executeUpdate();

                Query crt = session.createSQLQuery(userDataQuery + " where u.id='" + user_id + "'");
                list = crt.list();
                usersFieldDataList = fillUserTablePojo(list);
                TokenGenerator.tokenMap.put(token,token);
            } else {
                return null;
            }
            tx.commit();
        } catch (InfrastructureException ex) {
            tx.rollback();
            throw new CommandException(ex);
        } catch (BusinessException ex) {
        	tx.rollback();
            throw new CommandException(ex);
        } catch(Exception ex){
        	tx.rollback();
        	throw new CommandException(ex);
        }
        finally {
            session.close();
        }
        return usersFieldDataList;
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
                ssp.setSspId(AkdmUtils.getObject(newList[counter++],Integer.class));
                ssp.setSspTitle(AkdmUtils.getObject(newList[counter++],String.class));
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
                areas.setAreaId(AkdmUtils.getObject(newList[counter++],Integer.class));
                areas.setAreaTitle(AkdmUtils.getObject(newList[counter++],String.class));
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
                mandals.setMandalId(AkdmUtils.getObject(newList[counter++],Integer.class));
                mandals.setMandalTitle(AkdmUtils.getObject(newList[counter++],String.class));
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
            usersFieldData.setId(AkdmUtils.getObject(obj[counter++],Long.class));
            usersFieldData.setRole_id(AkdmUtils.getObject(obj[counter++],Integer.class));
            usersFieldData.setUser_name(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setEmail(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setPassword(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setPhone(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setWhatsapp_number(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setEmail_verified(AkdmUtils.getObject(obj[counter++],Boolean.class));
            usersFieldData.setBirth_date(AkdmUtils.getObject(obj[counter++],Date.class));
            usersFieldData.setUser_image(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setLatitude(AkdmUtils.getObject(obj[counter++],Double.class));
            usersFieldData.setLongitude(AkdmUtils.getObject(obj[counter++],Double.class));
            usersFieldData.setAddress(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setAuth_token(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setRelationship_status(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setCreated_at(AkdmUtils.getObject(obj[counter++],Date.class));
            usersFieldData.setUpdated_at(AkdmUtils.getObject(obj[counter++],Date.class));
            usersFieldData.setStatus(AkdmUtils.getObject(obj[counter++],Boolean.class));
            usersFieldData.setDevice_type(AkdmUtils.getObject(obj[counter++],Integer.class));
            usersFieldData.setDevice_token(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setBadge_count(AkdmUtils.getObject(obj[counter++],Integer.class));
            usersFieldData.setRole_name(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setArea_title(AkdmUtils.getObject(obj[counter++],String.class));
            usersFieldData.setMandal_title(AkdmUtils.getObject(obj[counter++],String.class));
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
					ps.setString(2, AkdmUtils.getObject(newData[0],String.class));
					ps.setString(3, AkdmUtils.getObject(newData[0],String.class) + "_Y_");
					ps.setString(4, (AkdmUtils.getObject(newData[0],String.class)).toLowerCase() + "@gmail.com");
					ps.setString(5, (AkdmUtils.getObject(newData[0],String.class)).toLowerCase());
					
					String phno = (AkdmUtils.getObject(newData[2],String.class)).replace("+", "");
					ps.setString(6, phno);
					
					String Whatsapp = (AkdmUtils.getObject(newData[3],String.class)).replace("+", "");
					ps.setString(7, Whatsapp);
					ps.setInt(8,1);
					
					String str = (AkdmUtils.getObject(newData[5],String.class));
					if(!"".equals(str)){
						ps.setDate(9,AkdmUtils.getObject(newData[5],Date.class));	
					}
					ps.setInt(10, 0);
					ps.setInt(11, 0);
					ps.setInt(12, 0);
					ps.setString(13, AkdmUtils.getObject(newData[6],String.class));
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
				sabhaData.setSabha_title(AkdmUtils.getObject(obj[counter++],String.class));
				sabhaData.setSabha_date(AkdmUtils.getObject(obj[counter++],Date.class));
				sabhaData.setMandal_id(AkdmUtils.getObject(obj[counter++],Integer.class));
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
				mandals.setMandalId(AkdmUtils.getObject(obj[counter++],Integer.class));
				mandals.setMandalTitle(AkdmUtils.getObject(obj[counter++],String.class));
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
				createSabhaData.setUser_id((AkdmUtils.getObject(object[counter++],Long.class)));
				createSabhaData.setUser_name(AkdmUtils.getObject(object[counter++],String.class));
				createSabhaData.setUser_uniqueid(AkdmUtils.getObject(object[counter++],String.class));
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
