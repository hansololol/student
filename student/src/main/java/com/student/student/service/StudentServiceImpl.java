package com.student.student.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.student.student.dao.StudentDAO;
import com.student.student.vo.StudentVO;
import com.student.student.vo.SubjectVO;

@Service("studentService")
	public class StudentServiceImpl implements StudentService {
		@Autowired
		private StudentDAO studentDAO;
		
		
		@Override
		public List listMembers() throws DataAccessException {
			// TODO Auto-generated method stub
			List memberList=null;
			memberList=studentDAO.selectAllMemberList();
			return memberList;
		}
		
		
		@Override
		public void addMember(Map articleMap) throws DataAccessException {
			// TODO Auto-generated method stub
			studentDAO.insertMember(articleMap);
		}

		@Override
			public SubjectVO addSubject(SubjectVO subjectVO) throws DataAccessException {
				// TODO Auto-generated method stub
				studentDAO.insertSubject(subjectVO);
				SubjectVO subjectVO1=selectSubject(subjectVO.getId());
				return subjectVO1;
			}
		@Override
		public SubjectVO selectSubject(String id) throws DataAccessException {
			// TODO Auto-generated method stub
			SubjectVO subjectVO=studentDAO.selectSubject(id);
			if(subjectVO!=null) {
			subjectVO.setAvg(studentDAO.selectAvg(subjectVO));
			subjectVO.setRank(studentDAO.selectRank(subjectVO));
			return subjectVO;
			}
			return null;
		}

		@Override
		public int removeMember(String id) throws DataAccessException {
			// TODO Auto-generated method stub
			return studentDAO.deleteMember(id);
		}

		@Override
		public int updateMember(StudentVO studentVO) throws DataAccessException {
			// TODO Auto-generated method stub
			System.out.print("모드");
			return studentDAO.updateMember(studentVO);
		}

		@Override
		public StudentVO selectMemberById1(String id) throws DataAccessException {
			// TODO Auto-generated method stub
			return studentDAO.selectMemberById1(id);
		}
		public Map selectMemberById() throws DataAccessException {
			// TODO Auto-generated method stub
			Map _id =studentDAO.selectMemberById();

			return _id;
		}

		@Override
		public StudentVO login(StudentVO studentVO) throws Exception {
			// TODO Auto-generated method stub
			return studentDAO.loginById(studentVO);
		}

	
	}

