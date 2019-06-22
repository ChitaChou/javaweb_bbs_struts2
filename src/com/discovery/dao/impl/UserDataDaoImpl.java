package com.discovery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.discovery.dao.UserDataDao;
import com.discovery.model.Admin;
import com.discovery.model.Area;
import com.discovery.model.Forum;
import com.discovery.model.Reply;
import com.discovery.model.Threads;
import com.discovery.model.User;
import com.discovery.utils.DBUtil;
import com.discovery.utils.DateUtil;
import com.discovery.utils.GetUserNickname;

public class UserDataDaoImpl implements UserDataDao{

	public List getAreaList() throws Exception {
		int num_areas = 0;
		List<Area> area_data = new ArrayList<Area>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`area`";
		Connection dbConn;
		PreparedStatement areaPS;
		ResultSet areaRS;

		dbConn = DBUtil.getconn();

		areaPS = DBUtil.getState(dbConn, sql);
		areaRS = areaPS.executeQuery();
		
		while (areaRS.next()) {
			Area temp = new Area();
			temp.setArea_id((String)areaRS.getObject(1));
			temp.setArea_name((String)areaRS.getObject(2));
			temp.setArea_desc((String)areaRS.getObject(3));
			area_data.add(temp);
			num_areas++;
		}
		
		
		DBUtil.close(areaRS);
		DBUtil.close(areaPS);
		DBUtil.close(dbConn);
		
		return area_data;
	}

	public List getForumList() throws Exception {
		int num_forums = 0;
		List<Forum> forum_data = new ArrayList<Forum>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`forum`";
		Connection dbConn;
		PreparedStatement forumPS;
		ResultSet forumRS;

		dbConn = DBUtil.getconn();

		forumPS = DBUtil.getState(dbConn, sql);
		forumRS = forumPS.executeQuery();
		
		while (forumRS.next()) {
			Forum temp = new Forum();
			temp.setForum_id((String)forumRS.getObject(1));
			temp.setForum_name((String)forumRS.getObject(2));
			temp.setForum_desc((String)forumRS.getObject(3));
			temp.setBy_area_id((String)forumRS.getObject(4));
			forum_data.add(temp);
			num_forums++;
		}
		
		
		DBUtil.close(forumRS);
		DBUtil.close(forumPS);
		DBUtil.close(dbConn);
		
		return forum_data;
	}

	public int createUser(User newUser) throws Exception {
		int result = 1;
		
		String sql = "insert into `javaweb_bbs`.`user` (`user_id`,`user_name`,`user_nickname`,`user_password`,`user_sex`,`user_email`,`user_phone`,`user_hobby`,`user_avatar_path`)"+" values (?,?,?,?,?,?,?,?,?)";
		Connection createConn;
		PreparedStatement createPS;
		
		createConn = DBUtil.getconn();
		createPS = DBUtil.getState(createConn, sql);
		
		createPS.setString(1, DateUtil.generateUserID());
		createPS.setString(2, newUser.getUser_name());
		createPS.setString(3, newUser.getUser_nickname());
		createPS.setString(4, newUser.getUser_password());
		createPS.setString(5, newUser.getUser_sex());
		createPS.setString(6, newUser.getUser_email());
		createPS.setString(7, newUser.getUser_phone());
		createPS.setString(8, newUser.getUser_hobby());
		createPS.setString(9, "user_avatar/default.png");
		try {
			createPS.executeUpdate();
			result = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		DBUtil.close(createPS);
		DBUtil.close(createConn);
		
		return result;
	}

	public List getUserSearchResultList(String search_condition,
			String search_content) throws Exception {
		int num_results = 0;
		List<User> userSearchResult_data = new ArrayList<User>();
		String sql = "SELECT * FROM `javaweb_bbs`.`user` WHERE "+search_condition+" LIKE ? ";
		Connection dbConn;
		PreparedStatement searchPS;
		ResultSet searchRS;

		dbConn = DBUtil.getconn();

		searchPS = DBUtil.getState(dbConn, sql);
		
		searchPS.setString(1, "%"+search_content+"%");
		searchRS = searchPS.executeQuery();
		
		while (searchRS.next()) {
			User temp = new User();
			temp.setUser_id((String)searchRS.getObject(1));
			temp.setUser_nickname((String)searchRS.getObject(3));
			temp.setUser_sex((String)searchRS.getObject(5));
			temp.setUser_email((String)searchRS.getObject(6));
			temp.setUser_phone((String)searchRS.getObject(7));
			temp.setUser_hobby((String)searchRS.getObject(8));
			userSearchResult_data.add(temp);
			num_results++;
		}
		
		
		DBUtil.close(searchRS);
		DBUtil.close(searchPS);
		DBUtil.close(dbConn);
		
		return userSearchResult_data;
	}

	public List getForumInfo(String forum_id) throws Exception {
		List<Forum> forum_data = new ArrayList<Forum>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`forum` WHERE forum_id = ?";
		Connection dbConn;
		PreparedStatement forumPS;
		ResultSet forumRS;

		dbConn = DBUtil.getconn();

		forumPS = DBUtil.getState(dbConn, sql);
		forumPS.setString(1, forum_id);
		forumRS = forumPS.executeQuery();
		
		while (forumRS.next()) {
			Forum temp = new Forum();
			temp.setForum_id((String)forumRS.getObject(1));
			temp.setForum_name((String)forumRS.getObject(2));
			temp.setForum_desc((String)forumRS.getObject(3));
			temp.setBy_area_id((String)forumRS.getObject(4));
			forum_data.add(temp);
		}
		
		
		DBUtil.close(forumRS);
		DBUtil.close(forumPS);
		DBUtil.close(dbConn);
		
		return forum_data;
	}

	public List getThreadList(String forum_id,int page,int pageSize) throws Exception {
		List<Threads> thread_data = new ArrayList<Threads>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`thread` WHERE by_forum_id = ? limit ?,?";
		Connection dbConn;
		PreparedStatement threadsPS;
		ResultSet threadsRS;

		dbConn = DBUtil.getconn();

		threadsPS = DBUtil.getState(dbConn, sql);
		threadsPS.setString(1, forum_id);
		threadsPS.setInt(2, pageSize*(page-1));
		threadsPS.setInt(3, pageSize);
		threadsRS = threadsPS.executeQuery();
		
		while (threadsRS.next()) {
			Threads temp = new Threads();
			temp.setThread_id((String)threadsRS.getObject(1));
			temp.setWriter_id(GetUserNickname.getUserNicknameByID((String)threadsRS.getObject(2)));
			temp.setBy_forum_id((String)threadsRS.getObject(3));
			temp.setCreate_time(DateUtil.formatTime((String)threadsRS.getObject(4)));
			temp.setLatest_post_time(DateUtil.formatTime((String)threadsRS.getObject(5)));
			temp.setThread_title((String)threadsRS.getObject(6));
			temp.setThread_text((String)threadsRS.getObject(7));
			thread_data.add(temp);
		}
		
		
		DBUtil.close(threadsRS);
		DBUtil.close(threadsPS);
		DBUtil.close(dbConn);
		
		return thread_data;
	}

	public List getThreadInfo(String thread_id) throws Exception {
		List<Threads> threadInfo_data = new ArrayList<Threads>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`thread` WHERE thread_id = ?";
		Connection dbConn;
		PreparedStatement threadPS;
		ResultSet threadRS;

		dbConn = DBUtil.getconn();

		threadPS = DBUtil.getState(dbConn, sql);
		threadPS.setString(1, thread_id);
		threadRS = threadPS.executeQuery();
		
		while (threadRS.next()) {
			Threads temp = new Threads();
			temp.setThread_id((String)threadRS.getObject(1));
			temp.setWriter_id(GetUserNickname.getUserNicknameByID((String)threadRS.getObject(2)));
			temp.setBy_forum_id((String)threadRS.getObject(3));
			temp.setCreate_time(DateUtil.formatTime((String)threadRS.getObject(4)));
			temp.setLatest_post_time(DateUtil.formatTime((String)threadRS.getObject(5)));
			temp.setThread_title((String)threadRS.getObject(6));
			temp.setThread_text((String)threadRS.getObject(7));
			threadInfo_data.add(temp);
		}
		
		
		DBUtil.close(threadRS);
		DBUtil.close(threadPS);
		DBUtil.close(dbConn);
		
		return threadInfo_data;
	}

	public List getReplyList(String thread_id) throws Exception {
		List<Reply> replyList_data = new ArrayList<Reply>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`reply` WHERE by_thread_id = ?";
		Connection dbConn;
		PreparedStatement replyPS;
		ResultSet replyRS;

		dbConn = DBUtil.getconn();

		replyPS = DBUtil.getState(dbConn, sql);
		replyPS.setString(1, thread_id);
		replyRS = replyPS.executeQuery();
		
		while (replyRS.next()) {
			Reply temp = new Reply();
			temp.setReply_id((String)replyRS.getObject(1));
			temp.setReply_writer_id(GetUserNickname.getUserNicknameByID((String)replyRS.getObject(2)));
			temp.setBy_thread_id((String)replyRS.getObject(3));
			temp.setReply_time(DateUtil.formatTime((String)replyRS.getObject(4)));
			temp.setReply_text((String)replyRS.getObject(5));
			if((String)replyRS.getObject(6)==null){
				temp.setSecond_reply_id((String)replyRS.getObject(6));
			}
			else{
				temp.setSecond_reply_id(GetUserNickname.getUserNicknameByReplyID((String)replyRS.getObject(6)));
			}
			
			replyList_data.add(temp);
		}
		
		
		DBUtil.close(replyRS);
		DBUtil.close(replyPS);
		DBUtil.close(dbConn);
		
		return replyList_data;
	}

	public int publishNewThread(Threads newThread) throws Exception {
		int result = 1;
		
		String sql = "insert into `javaweb_bbs`.`thread`"+" values (?,?,?,?,?,?,?)";
		Connection createConn;
		PreparedStatement createPS;
		
		createConn = DBUtil.getconn();
		createPS = DBUtil.getState(createConn, sql);
		
		String time_temp = DateUtil.generateUserID();
		createPS.setString(1, time_temp);
		createPS.setString(2, newThread.getWriter_id());
		createPS.setString(3, newThread.getBy_forum_id());
		createPS.setString(4, time_temp);
		createPS.setString(5, time_temp);
		createPS.setString(6, newThread.getThread_title());
		createPS.setString(7, newThread.getThread_text());
		
		try {
			createPS.executeUpdate();
			result = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		DBUtil.close(createPS);
		DBUtil.close(createConn);
		
		return result;
	}

	public int publishNewReply(Reply newReply) throws Exception {
		int result = 1;
		
		String sql = "insert into `javaweb_bbs`.`reply`"+" values (?,?,?,?,?,?)";
		
		Connection createConn;
		PreparedStatement createPS;
		
		createConn = DBUtil.getconn();
		createPS = DBUtil.getState(createConn, sql);
		
		String time_temp = DateUtil.generateUserID();
		createPS.setString(1, time_temp);
		createPS.setString(2, newReply.getReply_writer_id());
		createPS.setString(3, newReply.getBy_thread_id());
		createPS.setString(4, time_temp);
		createPS.setString(5, newReply.getReply_text());
		try {
			createPS.setString(6, newReply.getSecond_reply_id());
		} catch (Exception e) {
			createPS.setString(6, null);
		}
		
		String sql_update_posttime = "update `javaweb_bbs`.`thread` set latest_post_time=? where thread_id =? ";
		
		Connection updateConn;
		PreparedStatement updatePS;
		
		updateConn = DBUtil.getconn();
		updatePS = DBUtil.getState(updateConn, sql_update_posttime);
		
		updatePS.setString(1, time_temp);
		updatePS.setString(2, newReply.getBy_thread_id());
		
		try {
			createPS.executeUpdate();
			updatePS.executeUpdate();
			result = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		DBUtil.close(createPS);
		DBUtil.close(createConn);
		DBUtil.close(updatePS);
		DBUtil.close(updateConn);
		
		return result;
	}

	public List toEditUserPage(String edit_user_id) throws Exception {
		List<User> edit_user = new ArrayList<User>();
		
		String sql = "SELECT * from `javaweb_bbs`.`user` where user_id = ?";
		Connection dbConn;
		PreparedStatement userPS;
		ResultSet userRS;

		dbConn = DBUtil.getconn();

		userPS = DBUtil.getState(dbConn, sql);
		userPS.setString(1, edit_user_id);
		userRS = userPS.executeQuery();
		
		while (userRS.next()) {
			User temp = new User();
			temp.setUser_id((String)userRS.getObject(1));
			temp.setUser_name((String)userRS.getObject(2));
			temp.setUser_nickname((String)userRS.getObject(3));
			temp.setUser_password((String)userRS.getObject(4));
			if(userRS.getObject(5).toString().equals("男")){
				temp.setUser_sex("m");
			}
			else{
				if(userRS.getObject(5).toString().equals("女")){
					temp.setUser_sex("f");
				}
				else{
					temp.setUser_sex("unknown");
				}
			}
			temp.setUser_sex((String)userRS.getObject(5));
			temp.setUser_email((String)userRS.getObject(6));
			temp.setUser_phone((String)userRS.getObject(7));
			temp.setUser_hobby((String)userRS.getObject(8));
			temp.setUser_avatar_path((String)userRS.getObject(9));
			edit_user.add(temp);
		}
		
		
		DBUtil.close(userRS);
		DBUtil.close(userPS);
		DBUtil.close(dbConn);
		
		return edit_user;
	}

	public int setEditedUser(User edited_user) throws Exception {
		int result = 1;
		
		String sql = "update `javaweb_bbs`.`user` set user_nickname = ? , user_sex = ?,user_email = ?,user_phone = ?,user_hobby = ?,user_avatar_path = ? where user_id = ?";
		Connection editConn;
		PreparedStatement editPS;
		
		editConn = DBUtil.getconn();
		editPS = DBUtil.getState(editConn, sql);
		editPS.setString(1, edited_user.getUser_nickname());
		if(edited_user.getUser_sex().equals("m"))
			editPS.setString(2, "男");
		else{
			if(edited_user.getUser_sex().equals("f")){
				editPS.setString(2, "女");
			}
			else{
				editPS.setString(2, "未知");
			}
		}
		editPS.setString(3, edited_user.getUser_email());
		editPS.setString(4, edited_user.getUser_phone());
		editPS.setString(5, edited_user.getUser_hobby());
		editPS.setString(6, edited_user.getUser_avatar_path());
		editPS.setString(7, edited_user.getUser_id());
		
		try {
			editPS.executeUpdate();
			result = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		DBUtil.close(editPS);
		DBUtil.close(editConn);
		
		return result;
	}

	public List toUserAllThread(String pc_user_id) throws Exception {
		List<Threads> user_threads = new ArrayList<Threads>();
		
		String sql = "SELECT * from `javaweb_bbs`.`thread` where writer_id = ?";
		Connection dbConn;
		PreparedStatement userPS;
		ResultSet userRS;

		dbConn = DBUtil.getconn();

		userPS = DBUtil.getState(dbConn, sql);
		userPS.setString(1, pc_user_id);
		userRS = userPS.executeQuery();
		
		while (userRS.next()) {
			Threads temp = new Threads();
			temp.setThread_id((String)userRS.getObject(1));
			temp.setWriter_id((String)userRS.getObject(2));
			temp.setBy_forum_id((String)userRS.getObject(3));
			temp.setCreate_time(DateUtil.formatTime((String)userRS.getObject(4)));
			temp.setLatest_post_time(DateUtil.formatTime((String)userRS.getObject(5)));
			temp.setThread_title((String)userRS.getObject(6));
			temp.setThread_text((String)userRS.getObject(7));
			user_threads.add(temp);
		}
		
		
		DBUtil.close(userRS);
		DBUtil.close(userPS);
		DBUtil.close(dbConn);
		
		return user_threads;
	}

	public List toUserAllReply(String pc_user_id) throws Exception {
		List<Reply> user_reply = new ArrayList<Reply>();
		
		String sql = "SELECT * from `javaweb_bbs`.`reply` where reply_writer_id = ?";
		Connection dbConn;
		PreparedStatement userPS;
		ResultSet userRS;

		dbConn = DBUtil.getconn();

		userPS = DBUtil.getState(dbConn, sql);
		userPS.setString(1, pc_user_id);
		userRS = userPS.executeQuery();
		
		while (userRS.next()) {
			Reply temp = new Reply();
			temp.setReply_id((String)userRS.getObject(1));
			temp.setReply_writer_id((String)userRS.getObject(2));
			temp.setBy_thread_id((String)userRS.getObject(3));
			temp.setReply_time(DateUtil.formatTime((String)userRS.getObject(4)));
			temp.setReply_text((String)userRS.getObject(5));
			temp.setSecond_reply_id((String)userRS.getObject(6));
			user_reply.add(temp);
		}
		
		
		DBUtil.close(userRS);
		DBUtil.close(userPS);
		DBUtil.close(dbConn);
		
		return user_reply;
	}

	public int setEditedUserAvatar(User edited_user) throws Exception {
int result = 1;
		
		String sql = "update `javaweb_bbs`.`user` set user_avatar_path = ?  where user_id = ?";
		Connection editConn;
		PreparedStatement editPS;
		
		editConn = DBUtil.getconn();
		editPS = DBUtil.getState(editConn, sql);
		editPS.setString(1, edited_user.getUser_avatar_path());
		editPS.setString(2, edited_user.getUser_id());
		
		try {
			editPS.executeUpdate();
			result = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		DBUtil.close(editPS);
		DBUtil.close(editConn);
		
		return result;
	}

}
