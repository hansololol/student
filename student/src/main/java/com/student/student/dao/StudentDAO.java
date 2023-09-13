package com.student.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.student.student.vo.StudentVO;
import com.student.student.vo.SubjectVO;
@Mapper
@Repository("studentDAO")
public interface StudentDAO {
	public List selectAllMemberList() throws DataAccessException;
	public SubjectVO selectSubject(String id) throws DataAccessException;
	public int insertMember(Map articleMap) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public int updateMember(StudentVO studentVO) throws DataAccessException;
	public Map selectMemberById()throws DataAccessException;
	public StudentVO selectMemberById1(String id)throws DataAccessException;
	public StudentVO loginById(StudentVO studentVO)throws DataAccessException;
	public int insertSubject(SubjectVO subjectVO)throws DataAccessException;
	public int selectAvg(SubjectVO subjectVO)throws DataAccessException;
	public int selectSum(SubjectVO subjectVO)throws DataAccessException;
	public int selectRank(SubjectVO subjectVO)throws DataAccessException;
	public void updateSumList(Map subject)throws DataAccessException;
	
}
