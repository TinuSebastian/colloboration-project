package com.niit.colloboration_backendDAO;

import java.util.ArrayList;

import com.niit.colloboration_backendModel.Blog;
import com.niit.colloboration_backendModel.BlogComments;

public interface BlogDao 
{
	
		public boolean addBlog(Blog blog);
		public boolean updateBlog(Blog blog);
		public boolean deleteBlog(Blog blog);
		public Blog getBlog(int blogId);
		public ArrayList<Blog> getAllBlogs();
		public boolean approveBlog(Blog blog);
		public boolean rejectBlog(Blog blog);
		public boolean addBlogComment(BlogComments blogcomment);
		public boolean deleteBlogComment(BlogComments blogcomment);
		public boolean updateBlogComment(BlogComments blogcomment);
		public BlogComments getBlogComment(int commentId);
		public ArrayList<BlogComments> getAllBlogComments(int blogid);
		public boolean like(int blogid);
		public boolean dislike(int blogid);
		public boolean incview(int blogid);
		public ArrayList<Blog> getAllBlogRequests();
		public ArrayList<Blog> getAllMyBlogs(String email);
		
	}



