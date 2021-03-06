package com.niit.colloboration_backendDAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.h2.engine.Session;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.colloboration_backendDAO.UsersDao;
import com.niit.colloboration_backendModel.Friend;
import com.niit.colloboration_backendModel.Users;
@Repository("userDAO")
public class UsersDaoImpl  implements UsersDao{
	
		@Autowired
		SessionFactory sessionFactory;
		@Autowired
		public void UsersDAOImpl(SessionFactory sessionfactory)
		{
			this.sessionFactory=sessionfactory;
		}
		 @Transactional
			public ArrayList<Users> getAllUser() {
				
				String hql = "from Users";
				Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);		
				return (ArrayList<Users>) query.list();
				
			}
		  @Transactional
		  public boolean saveUser(Users user) {
		  	
		  	try {
		  		sessionFactory.getCurrentSession().save(user);
		  		return true;
		  	} catch (HibernateException e) {
		  		// TODO Auto-generated catch block
		  		e.printStackTrace();
		  		return false;
		  	}
		  }
		  
		  @Transactional	  
		public boolean updateOnlineStatus(Users user) {
			try{
				
				sessionFactory.getCurrentSession().saveOrUpdate(user);
				return true;
			}
			catch(Exception e)
			{
				
				return false;
			}
			
		}
		  
		@Transactional 
		public Users getUser(int userid) {
			
			System.err.println(userid);
			Users user=new Users();
			try{
				Session session= (Session) sessionFactory.openSession();
				Query query=(Query) ((SharedSessionContract) session).createQuery("from Users where userid="+userid);
				 user=(Users)((org.hibernate.Query) query).list().get(0);
				session.close();
				
			}
			catch(Exception e)
			{
				
				
			}
			return user;
			
		}
		
		
		@Transactional 
		public Users getUserbyId(int userid) {
			
			
			Users user=new Users();
			try{
				Session session= (Session) sessionFactory.openSession();
				Query query=(Query) ((SharedSessionContract) session).createQuery("from Users where userid="+userid);
				 user=(Users)((org.hibernate.Query) query).list().get(0);
				session.close();
				
			}
			catch(Exception e)
			{
				
				
			}
			return user;
			
		}
		@Transactional
		public boolean checkLogin(Users user) {
			try{
				Session session=(Session) sessionFactory.openSession();
			
				Query query=(Query) ((SharedSessionContract) session).createQuery("from Users where (email='"+user.getEmail()+"' and password='"+user.getPassword()+"') and (status='A')");
				
				ArrayList<Users> user1=(ArrayList<Users>)((org.hibernate.Query) query).list();
				
				if(user1.isEmpty())
				{
					
					return false;
				}
				else
				{
					return true;
				}
			}catch(Exception e)
			{
				return false;
			}
		}
		
		@Transactional
		public boolean checkLoginsimp(Users user) {
			
				Session session=(Session) sessionFactory.openSession();
			
				Query query=(Query) ((SharedSessionContract) session).createQuery("from Users where email='"+user.getEmail()+"' and password='"+user.getPassword()+"'");
				
				ArrayList<Users> user1=(ArrayList<Users>)((org.hibernate.Query) query).list();
				if(user1.isEmpty())
				{
					return false;
				}
				else
				{
					return true;
				}
			
			
		}
		
		@Transactional
		public boolean checkLoginsemail(Users user) {
			
				Session session=(Session) sessionFactory.openSession();
			
				Query query=(Query) ((SharedSessionContract) session).createQuery("from Users where email='"+user.getEmail()+"'");
				ArrayList<Users> us=(ArrayList<Users>)((org.hibernate.Query) query).list();
				if(us.isEmpty())
					{
					return false;
					}
				else
				{
					return true;
				}
							
			
		}
		
		
		
		
		@Transactional
		public Users getUserbyemail(String email) {
			Users user=new Users();
			try{
				Session session= (Session) sessionFactory.openSession();
				Query query=(Query) ((SharedSessionContract) session).createQuery("from Users where email='"+email+"'");
				 user=(Users)((org.hibernate.Query) query).list().get(0);
				session.close();
				
			}
			catch(Exception e)
			{
				
				
			}
			return user;
			
		}
		
		
		@Transactional
		public ArrayList<Friend> checkismyfriend(int userid, int myid) {

			Session session = (Session) sessionFactory.openSession();
			ArrayList<Friend> myfriends=(ArrayList<Friend>) ((SharedSessionContract) session).createQuery("from Friend where (U_ID="+myid+" and FRI_ID="+userid+") or (U_ID="+userid+" or FRI_ID="+myid+") and (status='YES')").list();
			session.close();
			return myfriends;
		}
		
	@Transactional 
	public ArrayList<Users> userrequests()
	{
		Session session = (Session) sessionFactory.openSession();
		ArrayList<Users> userreq=(ArrayList<Users>) ((SharedSessionContract) session).createQuery("from Users where status='P'").list();
		session.close();
		return userreq;
	}
	@Transactional
	public boolean approveusers(Users users)
	{
		try {
	  		sessionFactory.getCurrentSession().saveOrUpdate(users);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
		}

	

		


	@Transactional
	public boolean rejectusers(Users users)
	{
		try {
	  		sessionFactory.getCurrentSession().saveOrUpdate(users);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
	}
}	
	