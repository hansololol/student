package com.student.student.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.student.student.vo.StudentVO;
import com.student.student.vo.SubjectVO;

public interface StudentService {
	public List listMembers() throws DataAccessException;
	public void addMember(Map articleMap) throws DataAccessException;
	public int removeMember(String id) throws DataAccessException;
	public int updateMember(StudentVO studentVO) throws DataAccessException;
	public Map selectMemberById()throws DataAccessException;
	public StudentVO selectMemberById1(String id)throws DataAccessException;
	public StudentVO login(StudentVO studentVO)throws Exception;
	public SubjectVO addSubject(SubjectVO subjectVO) throws DataAccessException;
	SubjectVO selectSubject(String id) throws DataAccessException;
}
