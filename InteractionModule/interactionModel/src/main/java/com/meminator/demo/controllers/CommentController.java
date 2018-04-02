package com.meminator.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meminator.demo.services.CommentService;

@RestController
@RequestMapping(value="/comments")
public class CommentController {
	
	CommentService commentService; 
	
	@Autowired
	public void setCommentService(CommentService commentService)	{
		this.commentService = commentService; 
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String createComment(@RequestBody final commentInfo commentInfo)
	{
		return this.commentService.createComment(
				Long.valueOf(commentInfo.postId).longValue()
				, commentInfo.commenterUsername
				, commentInfo.commentText
				);
	}
	
	@RequestMapping(value="/username={username}/commentId={commentId}", method=RequestMethod.DELETE)
	public String deleteComment(@PathVariable("username") String usnername, @PathVariable("commentId") String commentId)	{
		
		return this.commentService.deleteComment(usnername, Long.valueOf(commentId).longValue());
	}
	private static class commentInfo	{
		public String postId;
		public String commenterUsername; 
		public String commentText; 
	}
}
