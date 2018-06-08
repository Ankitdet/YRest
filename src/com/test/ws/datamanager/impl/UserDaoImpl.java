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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
import com.test.ws.entities.MandalYuvak;
import com.test.ws.entities.Mandals;
import com.test.ws.entities.SabhaData;

import com.test.ws.entities.Ssp;
import com.test.ws.entities.UsersFieldData;
import com.test.ws.entities.YuAttendance;
import com.test.ws.exception.BusinessException;
import com.test.ws.exception.CommandException;
import com.test.ws.exception.InfrastructureException;
import com.test.ws.logger.Logger;
import com.test.ws.requestobject.Response;
import com.test.ws.table.metadata.CLMS;
import com.test.ws.table.metadata.SqlStaticQuery;
import com.test.ws.table.metadata.TBLS;
import com.test.ws.utils.AkdmUtils;
import com.test.ws.utils.HibernateUtil;
import com.test.ws.utils.TokenGenerator;

public class UserDaoImpl implements UserDao {

	public static final String MODULE = UserDaoImpl.class.getSimpleName();

	/**
	 * Initialize counter variable for get COLUMN values
	 */

	public static int counter;

	public static final String userDataQuery = "select " + "u." + CLMS.ID + "," + "u." + CLMS.USERNAME + "," + "u."
			+ CLMS.EMAIL + "," + "u." + CLMS.PASSWORD + "," + "u." + CLMS.PHONE + "," + "u." + CLMS.WHATSAPP_NUMBER
			+ "," + "u." + CLMS.EMAIL_VERIFIED + "," + "u." + CLMS.BIRTH_DATE + "," + "u." + CLMS.USER_IMAGE + ","
			+ "u." + CLMS.LATITUDE + "," + "u." + CLMS.LONGITUDE + "," + "u." + CLMS.ADDRESS + "," + "u."
			+ CLMS.AUTH_TOKEN + "," + "u." + CLMS.RELATIONSHIP_STATUS + "," + "u." + CLMS.CREATED_AT + "," + "u."
			+ CLMS.UPDATED_AT + "," + "u." + CLMS.STATUS + "," + "u." + CLMS.DEVICE_TYPE + "," + "u."
			+ CLMS.DEVICE_TOKEN + "," + "u." + CLMS.BADGE_COUNT + "," + "ur." + CLMS.ROLE_NAME + "," + "ar."
			+ CLMS.AREA_TITLE + "," + "m." + CLMS.MANDAL_TITLE + "," + "u." + CLMS.MANDAL_ID + "," + "u." + CLMS.AREA_ID
			+ "," + "u." + CLMS.ROLE_ID + " " + "from " + TBLS.USER + " u " + "left join " + TBLS.USERROLE
			+ " ur on ur." + CLMS.ID + "=u." + CLMS.ROLE_ID + " left join " + TBLS.AREA + " ar on ar." + CLMS.AREA_ID
			+ "=u." + CLMS.AREA_ID + " " + "left join " + TBLS.MANDAL + " m on m." + CLMS.MANDAL_ID + " = u."
			+ CLMS.MANDAL_ID + " ";

	@Override
	public List<UsersFieldData> validateLogin(String email, String password) throws CommandException {
		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Long user_id = 0l;
		List<Object[]> list = null;
		String queryString = "";
		List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {

			String token = TokenGenerator.uniqueUUID();
			queryString = "SELECT * FROM " + TBLS.USER + " WHERE " + CLMS.EMAIL + "='" + email + "' AND "
					+ CLMS.PASSWORD + "='" + password + "'";
			Query query = session.createSQLQuery(queryString);
			list = query.list();

			if (!list.isEmpty()) {
				for (Object[] o : list) {
					user_id = ((BigInteger) o[0]).longValue();
				}

				queryString = "UPDATE " + TBLS.USER + " SET " + CLMS.AUTH_TOKEN + "='" + token + "'," + CLMS.UPDATED_AT
						+ "='" + AkdmUtils.getFormatedDate() + "' where " + CLMS.ID + "='" + user_id + "'";
				query = session.createSQLQuery(queryString);
				query.executeUpdate();

				Query crt = session.createSQLQuery(userDataQuery + " WHERE u." + CLMS.ID + "='" + user_id + "'");
				list = crt.list();
				usersFieldDataList = fillUserTablePojo(list);
				TokenGenerator.tokenMap.put(token, token);
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
		} catch (Exception ex) {
			tx.rollback();
			throw new CommandException(ex);
		} finally {
			session.close();
		}
		return usersFieldDataList;
	}

	@Override
	public List<UsersFieldData> getUserContactList() throws CommandException {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Object[]> list = null;
		List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

		try {

			String userDataQuery = "select " + "u." + CLMS.ID + "," + "u." + CLMS.USERNAME + "," + "u." + CLMS.EMAIL
					+ "," + "u." + CLMS.PASSWORD + "," + "u." + CLMS.PHONE + "," + "u." + CLMS.WHATSAPP_NUMBER + ","
					+ "u." + CLMS.EMAIL_VERIFIED + "," + "u." + CLMS.BIRTH_DATE + "," + "u." + CLMS.USER_IMAGE + ","
					+ "u." + CLMS.LATITUDE + "," + "u." + CLMS.LONGITUDE + "," + "u." + CLMS.ADDRESS + ",";

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
	public Response getBirthday(String cakeId) throws CommandException {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();
		String queryString = "";
		List<Object[]> list = null;

		try {
			Long myBirthdayDigit = Long.parseLong(cakeId);

			if (myBirthdayDigit > 4)
				return new Response(ResultCode.OPERATION_NOT_SUPPORTED_599.code,
						"Invalid input " + myBirthdayDigit + ", allow 0 to 4", null, null, null);

			if (myBirthdayDigit == 0) {
				queryString = userDataQuery + " WHERE " + getBirthFilterQuery(cakeId) + " ORDER BY u." + CLMS.USER_NAME
						+ "";
			} else {
				queryString = userDataQuery + " WHERE " + getBirthFilterQuery(cakeId) + " ORDER BY MONTH("
						+ CLMS.BIRTH_DATE + ")";
			}
			Query queryNew = session.createSQLQuery(queryString);
			list = queryNew.list();

			if (!list.isEmpty()) {
				usersFieldDataList = fillUserTablePojo(list);
				return new Response(ResultCode.SUCCESS_200.code, "successfully get data", null, null,
						usersFieldDataList);
			} else {
				return new Response(ResultCode.SUCCESS_200.code, "No record found", null, null, usersFieldDataList);
			}
		} catch (NumberFormatException nx) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, "Number can't parse in long " + cakeId, null, null,
					null);
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ex.getMessage(), null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ex.getMessage(), null, null, null);
		} finally {
			session.close();
		}
	}

	@Override
	public Response getSSP() {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Ssp> sspList = new ArrayList<Ssp>();
		try {
			Query query = session.createSQLQuery(SqlStaticQuery.getSSPQuery);
			List<Object[]> list = query.list();

			for (Object[] newList : list) {
				counter = 0;
				Ssp ssp = new Ssp();
				ssp.setSspId(AkdmUtils.getObject(newList[counter++], Integer.class));
				ssp.setSspTitle(AkdmUtils.getObject(newList[counter++], String.class));
				sspList.add(ssp);
			}

		} catch (Exception e) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, e.getMessage(), null, null, null);
		} finally {
			session.close();
		}
		return new Response(ResultCode.SUCCESS_200.code, ResultCode.SUCCESS_200.name, null, null, sspList);
	}

	@Override
	public Response getArea() {
		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Areas> areasArrayList = new ArrayList<Areas>();

		try {
			Query query = session.createSQLQuery(SqlStaticQuery.getAreaQuery);
			List<Object[]> list = query.list();

			for (Object[] newList : list) {
				counter = 0;
				Areas areas = new Areas();
				areas.setAreaId(AkdmUtils.getObject(newList[counter++], Integer.class));
				areas.setAreaTitle(AkdmUtils.getObject(newList[counter++], String.class));
				areasArrayList.add(areas);
			}

		} catch (Exception e) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null,
					null);
		} finally {
			session.close();
		}
		return new Response(ResultCode.SUCCESS_200.code, ResultCode.SUCCESS_200.name, null, null, areasArrayList);
	}

	@Override
	public Response getManadal() {
		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Mandals> mandalsArrayList = new ArrayList<Mandals>();

		try {

			Query query = session.createSQLQuery(SqlStaticQuery.getMandalQuery);
			List<Object[]> list = query.list();

			for (Object[] newList : list) {
				counter = 0;
				Mandals mandals = new Mandals();
				mandals.setMandalId(AkdmUtils.getObject(newList[counter++], Integer.class));
				mandals.setMandalTitle(AkdmUtils.getObject(newList[counter++], String.class));

				String str = "SELECT count(*) FROM users WHERE mandal_id=" + mandals.getMandalId();
				Number mId = ((Number) session.createSQLQuery(str).uniqueResult()).longValue();
				mandals.setTotal_yuvak(mId.intValue());

				mandalsArrayList.add(mandals);
			}

		} catch (Exception e) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ResultCode.INTERNAL_ERROR_500.name, null, null,
					null);
		} finally {
			session.close();
		}
		return new Response(ResultCode.SUCCESS_200.code, ResultCode.SUCCESS_200.name, null, null, mandalsArrayList);
	}

	private List<UsersFieldData> fillUserTablePojo(List<Object[]> list) {
		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();
		for (Object[] obj : list) {
			counter = 0;
			UsersFieldData usersFieldData = new UsersFieldData();
			usersFieldData.setId(AkdmUtils.getObject(obj[counter++], Long.class));
			usersFieldData.setUser_name(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setEmail(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setPassword(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setPhone(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setWhatsapp_number(AkdmUtils.getObject(obj[counter++], String.class));
			/*
			 * usersFieldData.setEmail_verified(AkdmUtils.getObject(
			 * obj[counter++], Boolean.class));
			 */
//			usersFieldData.setBirth_date(AkdmUtils.getObject(obj[counter++], Date.class));
			usersFieldData.setUser_image(AkdmUtils.getObject(obj[counter++], String.class));
			/*
			 * usersFieldData.setLatitude(AkdmUtils.getObject(obj[counter++],
			 * Double.class));
			 * usersFieldData.setLongitude(AkdmUtils.getObject(obj[counter++],
			 * Double.class));
			 */
			usersFieldData.setAddress(AkdmUtils.getObject(obj[counter++], String.class));
			/*
			 * usersFieldData.setAuth_token(AkdmUtils.getObject(obj[counter++],
			 * String.class));
			 * usersFieldData.setRelationship_status(AkdmUtils.getObject(
			 * obj[counter++], String.class));
			 */
			usersFieldData.setCreated_at(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setUpdated_at(AkdmUtils.getObject(obj[counter++], String.class));
			/*
			 * usersFieldData.setStatus(AkdmUtils.getObject(obj[counter++],
			 * Boolean.class));
			 * usersFieldData.setDevice_type(AkdmUtils.getObject(obj[counter++],
			 * Integer.class));
			 * usersFieldData.setDevice_token(AkdmUtils.getObject(obj[counter++]
			 * , String.class));
			 */
			usersFieldData.setBadge_count(AkdmUtils.getObject(obj[counter++], Integer.class));
			usersFieldData.setRole_name(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setArea_title(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setMandal_title(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setMandal_id(AkdmUtils.getObject(obj[counter++], Integer.class));
			usersFieldData.setArea_id(AkdmUtils.getObject(obj[counter++], Integer.class));
			usersFieldData.setRole_id(AkdmUtils.getObject(obj[counter++], Integer.class));
			usersFieldData.setAttendance("100%");
			usersFieldDataList.add(usersFieldData);
		}

		Collections.sort(usersFieldDataList);
		return usersFieldDataList;
	}

	@Override
	public Response doCreateSabha(SabhaData sabhaData) {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		PreparedStatement ps = null;
		Statement st = null;
		int count = 0;
		List<BigInteger> list = null;

		try {

			String sql = "";
			Query q = null;

			for (Integer i : sabhaData.getMandal_id()) {

				sql = "INSERT INTO sabhas(SABHA_TITLE,MANDAL_ID,DATE,START_TIME,END_TIME,STATUS,CREATED_DATE,UPDATED_DATE)"
						+ " VALUES('" + sabhaData.getSabha_title() + "','" + i + "','" + AkdmUtils.getToday() + "','"
						+ AkdmUtils.getTime() + "','" + AkdmUtils.getSabhaEndTime() + "',false,'"
						+ AkdmUtils.getFormatedDate() + "','" + AkdmUtils.getFormatedDate() + "')";
				q = session.createSQLQuery(sql);
				q.executeUpdate();

			}

			sql = "SELECT ID FROM users WHERE MANDAL_ID='" + sabhaData.getMandal_id() + "'";
			q = session.createSQLQuery(sql);
			list = q.list();

			sql = "SELECT MAX(SABHA_ID) FROM sabhas WHERE MANDAL_ID='" + sabhaData.getMandal_id() + "'";
			q = session.createSQLQuery(sql);
			int sabha_id = ((Integer) q.uniqueResult()).intValue();

			try {
				SessionImplementor sessImpl = (SessionImplementor) session;
				Connection connection = sessImpl.connection();
				connection.setAutoCommit(false);
				st = connection.createStatement();

				sql = "INSERT INTO " + TBLS.YUVAATTENDANCE
						+ " (SABHA_ID,IS_ATTENDED,MANDAL_ID,USER_ID) VALUES(?,?,?,?)";
				ps = connection.prepareStatement(sql);
				ps.setBoolean(2, false);
				ps.setLong(3, sabhaData.getMandalId());

				for (Integer i : sabhaData.getMandal_id()) {
					for (BigInteger yAttendance : list) {
						ps.setLong(1, i);
						ps.setLong(4, AkdmUtils.getObject(yAttendance, Long.class));
						ps.addBatch();
						if (count % 100 == 0) {
							ps.executeBatch();
						}
						count++;
					}
					ps.executeBatch();
				}

			} catch (BatchUpdateException e) {
				int[] updateCounts = e.getUpdateCounts();
				Logger.logDebug(MODULE, "UpdateCounts :" + updateCounts.length);
				throw new BusinessException("Upload Translation Mapping Data Failed, Reason " + e.getMessage());
			} catch (HibernateException hExp) {
				tx.rollback();
				throw new BusinessException(hExp.getMessage(), hExp);
			} catch (Exception exp) {
				tx.rollback();
				throw new BusinessException(exp.getMessage(), exp);
			} finally {
				try {
					if (ps != null)
						ps.close();
					if (st != null)
						st.close();
					tx.commit();
				} catch (SQLException sExp) {
					tx.rollback();
					throw new BusinessException(sExp.getMessage(), sExp);
				}
			}

		} catch (Exception e) {
			tx.rollback();
			return new Response(ResultCode.INTERNAL_ERROR_500.code, e.getMessage(), null, null, null);
		} finally {
			session.close();
		}
		return new Response(ResultCode.SUCCESS_200.code, "Sabha successfully created!", null, null, null);
	}

	@Override
	public Response getSabhaDetails() {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<SabhaData> usersFieldDataList = new ArrayList<SabhaData>();

		try {
			queryString = "select " + CLMS.SABHA_ID + "," + CLMS.SABHA_TITLE + "," + CLMS.MANDAL_ID + "," + CLMS.DATE
					+ "," + CLMS.START_TIME + "," + CLMS.END_TIME + "," + CLMS.STATUS + "," + CLMS.CREATED_DATE + ","
					+ CLMS.UPDATED_DATE + " from " + TBLS.SABHA;
			Query query = session.createSQLQuery(queryString);
			List<Object[]> obj = query.list();

			for (Object[] objects : obj) {
				counter = 0;
				SabhaData sabhaData = new SabhaData();
				sabhaData.setId(AkdmUtils.getObject(objects[counter++], Long.class));
				sabhaData.setSabha_title(AkdmUtils.getObject(objects[counter++], String.class));
				// sabhaData.setMandal_id(AkdmUtils.getObject(objects[counter++],Integer.class));
				sabhaData.setMandalId(AkdmUtils.getObject(objects[counter++], Integer.class));
				sabhaData.setSabha_date(AkdmUtils.getObject(objects[counter++], Date.class));
				sabhaData.setStart_time(AkdmUtils.getObject(objects[counter++], String.class));
				sabhaData.setEnd_time(AkdmUtils.getObject(objects[counter++], String.class));
				sabhaData.setStatus(AkdmUtils.getObject(objects[counter++], Integer.class));
				sabhaData.setCreated_date(AkdmUtils.getObject(objects[counter++], Date.class));
				sabhaData.setUpdated_date(AkdmUtils.getObject(objects[counter++], Date.class));

				usersFieldDataList.add(sabhaData);
			}
		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ex.getMessage(), null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ex.getMessage(), null, null, null);
		} catch (Exception ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ex.getMessage(), null, null, null);
		} finally {
			session.close();
		}
		return new Response(ResultCode.SUCCESS_200.code, "Successfully get data", null, null, usersFieldDataList);
	}

	@Override
	public Response uploadDataByExcel(List<Object[]> list) {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		PreparedStatement ps = null;
		Transaction tx = session.beginTransaction();
		Statement st = null;
		int failedDataConunt = 0;
		int successDataCount = 0;

		try {

			Map<String, Integer> mandalIds = getMandalIds();

			SessionImplementor sessImpl = (SessionImplementor) session;
			Connection connection = sessImpl.connection();
			connection.setAutoCommit(false);
			st = connection.createStatement();

			// batch insert
			String sql = "INSERT INTO users"
					+ "(ROLE_ID,FIRSTNAME,USER_UNIQUEID,EMAIL,PASSWORD,PHONE,WHATSAPP_NUMBER,EMAIL_VERIFIED,BIRTH_DATE,USER_IMAGE,LATITUDE,LONGITUDE,ADDRESS,AREA_ID,MANDAL_ID,AUTH_TOKEN,RELATIONSHIP_STATUS,CREATED_AT,UPDATED_AT,STATUS,DEVICE_TYPE,DEVICE_TOKEN,BADGE_COUNT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			int i = 0;
			for (Object[] newData : list) {
				if (newData != null) {

					if (i == 0) {
						i++;
						continue;
					}
					ps.setInt(1, 3);

					if ("".equals(newData[0]))
						break;
					ps.setString(2, AkdmUtils.getObject(newData[0], String.class));
					ps.setString(3, AkdmUtils.getObject(newData[0], String.class) + "_Y_");
					ps.setString(4, (AkdmUtils.getObject(newData[0], String.class)).toLowerCase() + "@gmail.com");
					ps.setString(5, (AkdmUtils.getObject(newData[0], String.class)).toLowerCase());

					String phno = (AkdmUtils.getObject(newData[2], String.class)).replace("+", "");
					ps.setString(6, phno);

					String Whatsapp = (AkdmUtils.getObject(newData[3], String.class)).replace("+", "");
					ps.setString(7, Whatsapp);
					ps.setInt(8, 1);

					String str = (AkdmUtils.getObject(newData[5], String.class));
					if (!"".equals(str)) {
						ps.setDate(9, AkdmUtils.getObject(newData[5], Date.class));
					}
					ps.setInt(10, 0);
					ps.setInt(11, 0);
					ps.setInt(12, 0);
					ps.setString(13, AkdmUtils.getObject(newData[6], String.class));
					ps.setInt(14, 5);

					Integer mandalId = mandalIds.get(AkdmUtils.getObject(newData[1], String.class));
					ps.setInt(15, mandalId);
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
			tx.rollback();
			int[] updateCounts = e.getUpdateCounts();
			Logger.logDebug(MODULE, "UpdateCounts :" + updateCounts.length);
			throw new BusinessException("Upload Translation Mapping Data Failed, Reason " + e.getMessage());
		} catch (HibernateException hExp) {
			tx.rollback();
			Logger.logError(MODULE, hExp.getMessage());
		} catch (Exception exp) {
			tx.rollback();
			Logger.logError(MODULE, exp.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (st != null)
					st.close();
				tx.commit();
			} catch (SQLException sExp) {
				tx.rollback();
				throw new BusinessException(sExp.getMessage(), sExp);
			}
		}
		return new Response(ResultCode.SUCCESS_200.code, ResultCode.SUCCESS_200.name,
				"Inserted Record:" + successDataCount + "\nSkipped Record:" + failedDataConunt, null, null);
	}

	@Override
	public List<MandalYuvak> getMandalYuvakList(Integer mandal_id) {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<MandalYuvak> listMandalYuvak = new ArrayList<MandalYuvak>();

		try {
			queryString = "select u.user_name,m.mandal_title,u.id from users u left join mandals m on u.mandal_id=m.mandal_id where m.mandal_id="
					+ mandal_id + "";
			Query query = session.createSQLQuery(queryString);
			List<Object[]> object = query.list();

			for (Object[] obj : object) {
				counter = 0;
				MandalYuvak mandalYuvak = new MandalYuvak();
				mandalYuvak.setName(AkdmUtils.getObject(obj[counter++], String.class));
				mandalYuvak.setImage("1.png");
				mandalYuvak.setSector(AkdmUtils.getObject(obj[counter++], String.class));
				mandalYuvak.setUser_id(AkdmUtils.getObject(obj[counter++], Integer.class));
				listMandalYuvak.add(mandalYuvak);
			}

		} catch (InfrastructureException ex) {
			throw new InfrastructureException(ex);
		} catch (BusinessException ex) {
			throw new BusinessException(ex);
		} finally {
			session.close();
		}
		return listMandalYuvak;
	}

	@Override
	public List<UsersFieldData> getYuvakProfile(Integer user_id) {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

		try {
			queryString = userDataQuery + " WHERE u.ID=" + user_id;
			Query query = session.createSQLQuery(queryString);
			usersFieldDataList = fillUserTablePojo(query.list());

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
	public Response getSabhaMandalList(Integer sabha_id) {
		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Mandals> mandalList = new ArrayList<Mandals>();

		try {
			queryString = "SELECT MANDAL_ID,MANDAL_TITLE FROM " + TBLS.MANDAL
					+ " WHERE MANDAL_ID = (SELECT MANDAL_ID FROM " + TBLS.SABHA + " WHERE SABHA_ID=" + sabha_id + ")";
			Query query = session.createSQLQuery(queryString);
			List<Object[]> list = query.list();

			for (Object[] obj : list) {
				counter = 0;
				Mandals mandals = new Mandals();
				mandals.setMandalId(AkdmUtils.getObject(obj[counter++], Integer.class));
				mandals.setMandalTitle(AkdmUtils.getObject(obj[counter++], String.class));
				mandalList.add(mandals);
			}
			return new Response(ResultCode.SUCCESS_200.code, "Successfully get records", null, null, mandalList);

		} catch (InfrastructureException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ex.getMessage(), null, null, null);
		} catch (BusinessException ex) {
			return new Response(ResultCode.INTERNAL_ERROR_500.code, ex.getMessage(), null, null, null);
		} finally {
			session.close();
		}
	}

	@Override
	public List<CreateSabhaData> getSabhaYuvakList(Integer sabha_id, Integer mandal_id) {
		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		String queryString = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CreateSabhaData> userSabhaList = new ArrayList<CreateSabhaData>();

		try {
			queryString = "SELECT u.user_name,y.mandal_id,y.sabha_id,y.user_id,y.is_attended FROM "
					+ TBLS.YUVAATTENDANCE + " y LEFT JOIN " + TBLS.USER + " u ON y.user_id=u.id where y."
					+ CLMS.MANDAL_ID + "=" + mandal_id + " AND y." + CLMS.SABHA_ID + "=" + sabha_id + "";
			Query query = session.createSQLQuery(queryString);
			List<Object[]> list = query.list();

			for (Object[] object : list) {
				counter = 0;
				CreateSabhaData createSabhaData = new CreateSabhaData();
				createSabhaData.setYuvak_name(AkdmUtils.getObject(object[counter++], String.class));
				createSabhaData.setMandal_id(AkdmUtils.getObject(object[counter++], Long.class));
				createSabhaData.setSabhaId(AkdmUtils.getObject(object[counter++], Long.class));
				createSabhaData.setUser_id(AkdmUtils.getObject(object[counter++], Long.class));
				createSabhaData.setIs_Attended(AkdmUtils.getObject(object[counter++], Boolean.class));
				userSabhaList.add(createSabhaData);
			}

		} catch (InfrastructureException ex) {
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

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Logger.logInfo(MODULE, "Requested data : " + request.toString());
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		PreparedStatement ps = null;
		Statement st = null;
		int count = 0;

		try {
			SessionImplementor sessImpl = (SessionImplementor) session;
			Connection connection = sessImpl.connection();
			connection.setAutoCommit(false);
			st = connection.createStatement();

			String sql = "UPDATE " + TBLS.YUVAATTENDANCE + " SET " + CLMS.IS_ATTENDED + "=? WHERE " + CLMS.SABHA_ID
					+ "=? AND " + CLMS.MANDAL_ID + "=? AND " + CLMS.USER_ID + "=?";
			ps = connection.prepareStatement(sql);
			ps.setLong(2, request.getSabha_id());
			ps.setLong(3, request.getMandal_id());
			for (YuAttendance yAttendance : request.getListOfAttendance()) {
				ps.setLong(4, yAttendance.getYuvak_id());
				ps.setBoolean(1, yAttendance.isIs_attended());
				ps.addBatch();
				if (count % 100 == 0) {
					ps.executeBatch();
				}
				count++;
			}
			ps.executeBatch();
		} catch (BatchUpdateException e) {
			tx.rollback();
			return new Response(ResultCode.INTERNAL_ERROR_500.code, e.getMessage(), null, null, "rollback query");
		} catch (HibernateException e) {
			tx.rollback();
			return new Response(ResultCode.INTERNAL_ERROR_500.code, e.getMessage(), null, null, "rollback query");
		} catch (Exception e) {
			tx.rollback();
			return new Response(ResultCode.INTERNAL_ERROR_500.code, e.getMessage(), null, null, "rollback query");
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (st != null)
					st.close();
				tx.commit();
			} catch (SQLException sExp) {
				tx.rollback();
				throw new BusinessException(sExp.getMessage(), sExp);
			}
		}
		return new Response(ResultCode.SUCCESS_200.code, ResultCode.SUCCESS_200.name, "Insert record successfully",
				null, null);
	}

	private String getBirthFilterQuery(String id) {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());

		/**
		 * default 0 = today's if id 1 = 1 Week if id 2 = 1 Months if id 3 = 3
		 * Months if id 4 = 6 months
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
		int start_day = c.get(Calendar.DATE);
		int end_month = 0;
		int end_day = 0;

		StringBuffer sb = new StringBuffer();
		int val = Integer.valueOf(id);
		switch (val) {
		case 1:
			// Next 7 days
			c.add(Calendar.DATE, 7);
			end_day = c.get(Calendar.DATE);
			end_month = c.get(Calendar.MONTH);

			if (start_month == end_month) {
				sb.append(++start_month);
			} else {
				sb.append(++start_month).append(",").append(++end_month);
			}
			break;

		case 2:
			// Next 1 month
			c.add(Calendar.MONTH, 1);
			end_day = c.get(Calendar.DATE);
			end_month = c.get(Calendar.MONTH);
			sb.append(++start_month).append(",").append(++end_month);
			break;

		case 3:
			// Next 3 month
			c.add(Calendar.MONTH, 3);
			end_day = c.get(Calendar.DATE);
			end_month = c.get(Calendar.MONTH);

			for (int i = 1; i <= 4; i++) {
				if (start_month == 12) {
					start_month = 1;
					sb.append(start_month).append(",");
					continue;
				}
				sb.append(++start_month).append(",");
			}
			sb.replace(sb.length() - 1, sb.length(), "");

			break;

		case 4:

			// Next 6 month
			c.add(Calendar.MONTH, 6);
			end_day = c.get(Calendar.DATE);
			end_month = c.get(Calendar.MONTH);
			for (int i = 1; i <= 7; i++) {
				if (start_month == 12) {
					start_month = 1;
					sb.append(start_month).append(",");
					continue;
				}
				sb.append(++start_month).append(",");
			}
			sb.replace(sb.length() - 1, sb.length(), "");
			break;

		default:
			// current date
			end_day = start_day;
			sb.append(++start_month);
			break;
		}
		return "MONTH(" + com.test.ws.constant.Constants.BIRTH_DATE + ") In (" + sb + ") and DAY("
				+ com.test.ws.constant.Constants.BIRTH_DATE + ")>=" + start_day + " and DAY("
				+ com.test.ws.constant.Constants.BIRTH_DATE + ")<=" + end_day + "";
	}

	public static Map<String, Integer> getMandalIds() {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		Map<String, Integer> map1 = new HashMap<String, Integer>();

		try {
			String queryString = "SELECT mandal_id,area from mandal_area";
			Query query = session.createSQLQuery(queryString);
			List<Object[]> list = query.list();

			for (Object[] object : list) {

				int mandal_id = AkdmUtils.getObject(object[0], Integer.class);
				String area = AkdmUtils.getObject(object[1], String.class);
				map1.put(area, mandal_id);
			}

		} catch (Exception e) {

		} finally {
			session.close();
		}
		return map1;
	}

	@Override
	public List<UsersFieldData> getYuvakList() throws CommandException {
		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Object[]> list = null;
		List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();

		try {

			String userDataQuery = "select u.id,u.f_name,u.m_name,u.l_name,u.address,u.phone,u.user_image as image,a.area_title as sector from users u left join areas a on a.area_id=u.area_id";
			Query crt = session.createSQLQuery(userDataQuery);
			list = crt.list();
			usersFieldDataList = fillUserTableDataPojo(list);

		} catch (InfrastructureException ex) {
			throw new InfrastructureException(ex);
		} catch (BusinessException ex) {
			throw new BusinessException(ex);
		} finally {
			session.close();
		}
		return usersFieldDataList;
	}

	private List<UsersFieldData> fillUserTableDataPojo(List<Object[]> list) {

		Logger.logInfo(MODULE, AkdmUtils.getMethodName());
		List<UsersFieldData> usersFieldDataList = new ArrayList<UsersFieldData>();
		for (Object[] obj : list) {
			counter = 0;
			UsersFieldData usersFieldData = new UsersFieldData();
			usersFieldData.setId(AkdmUtils.getObject(obj[counter++], Long.class));
			usersFieldData.setF_name(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setM_name(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setL_name(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setAddress(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setPhone(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setUser_image(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldData.setArea_title(AkdmUtils.getObject(obj[counter++], String.class));
			usersFieldDataList.add(usersFieldData);
		}

		Collections.sort(usersFieldDataList);
		return usersFieldDataList;
	}

	@Override
	public Response registerYuvakDetail(UsersFieldData userFieldsData)
			throws CommandException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String first_name = userFieldsData.getF_name();
		String middle_name = userFieldsData.getM_name();
		String last_name = userFieldsData.getL_name();
		String address = userFieldsData.getAddress();
		String phone = userFieldsData.getPhone();

		Object birthday = userFieldsData.getBirth_date();
		Object areaId = userFieldsData.getArea_id();


		if (birthday == null) {
				birthday = (String) "";
			} else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date date;
					try {
						date = sdf1.parse((String)birthday);
						birthday = new java.sql.Date(date.getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		try {
				Query q = null;
				String query = "insert into users(f_name,m_name,l_name,address,phone,birth_date,area_id) "
						+ "values('"
						+ first_name
						+ "','"
						+ middle_name
						+ "','"
						+ last_name
						+ "','"
						+ address
						+ "','"
						+ phone
						+ "','"
						+ birthday
						+ "','"
						+ areaId+"')" ;
				q = session.createSQLQuery(query);
				q.executeUpdate();
				tx.commit();
			} catch (InfrastructureException ex) {
				tx.rollback();
				throw new CommandException(ex);
			} catch (BusinessException ex) {
				tx.rollback();
				throw new CommandException(ex);
			} catch (Exception ex) {
				tx.rollback();
				throw new CommandException(ex);
			} finally {
				session.close();
			}
		return null;

	}

	@Override
	public Response getExtraData() throws CommandException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,List<Ssp>> getDependentData() throws CommandException {
		
	List<Ssp> str = new ArrayList<Ssp>();
		
	Ssp ssp = new Ssp();
	ssp.setSspId(1);
	ssp.setSspTitle("Praranbh");
	
	Ssp ssp1 = new Ssp();
	ssp1.setSspId(2);
	ssp1.setSspTitle("Pravesh");
	
	Ssp ssp2 = new Ssp();
	ssp2.setSspId(3);
	ssp2.setSspTitle("Parichay");

	Ssp ssp3 = new Ssp();
	ssp3.setSspId(4);
	ssp3.setSspTitle("Pravin");

	
	str.add(ssp1);
	str.add(ssp);
	str.add(ssp2);
	str.add(ssp3);
	
	Map<String,List<Ssp>> map = new HashMap<String, List<Ssp>>();
	map.put("sector", str);
	return map;
	}

	/*
	 * @Override public <Sectors> Response getExtraData() throws
	 * CommandException {
	 * 
	 * Logger.logInfo(MODULE, AkdmUtils.getMethodName()); Session session =
	 * HibernateUtil.getSessionFactory().openSession(); List<Object[]> list =
	 * null; List<Sectors> sectorDataList = new ArrayList<Sectors>();
	 * 
	 * try {
	 * 
	 * String userDataQuery = "select area_id,area_title from areas"; Query crt
	 * = session.createSQLQuery(userDataQuery); list = crt.list();
	 * sectorDataList = fillExtraData(list);
	 * 
	 * } catch (InfrastructureException ex) { throw new
	 * InfrastructureException(ex); } catch (BusinessException ex) { throw new
	 * BusinessException(ex); } finally { session.close(); } return new
	 * Response(ResultCode.SUCCESS_200.code, "successfully get data", null,
	 * null, sectorDataList); }
	 * 
	 * private List<Sectors> fillExtraData(List<Object[]> list) {
	 * 
	 * List<Sectors> sectorList = new ArrayList<Sectors>(); for (Object[]
	 * newList : list) { counter = 0; Sectors sectors = new Sectors();
	 * sectors.setId(AkdmUtils.getObject(newList[counter++], String.class));
	 * sectors.setName(AkdmUtils.getObject(newList[counter++], String.class));
	 * sectorList.add(sectors); } return sectorList;
	 */
}
// }
