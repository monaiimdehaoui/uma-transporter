/**
 * 
 */
package com.univers.architecture.transporter.service;

import java.util.List;

import com.univers.architecture.transporter.model.TaskExecutionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.univers.architecture.transporter.dao.ITaskExecutionRepository;
import com.univers.architecture.transporter.model.TaskExecution;

/**
 * @author sabir
 *
 */
@Service
public class TaskExecutionServiceImpl implements ITaskExecutionService {

	private static final Logger log = LoggerFactory.getLogger(TaskExecutionServiceImpl.class);

	@Autowired
	private ITaskExecutionRepository taskExecutionRepository;

	@Override
	public Page<TaskExecution> getAllTaskExecution(String page,String size,String sort,String direction) {

		Page pagee = this.taskExecutionRepository.findAll(getPages(page,size,sort,direction));
		return pagee;
	}

	@Override
	public Page<TaskExecution> searchInTaskExecution(String page, String size, String sort, String direction,String key,String filter) {

		Page pagee ;
		switch (filter ){
			case "id" : pagee = this.taskExecutionRepository.findByIdContaining(key,getPages(page,size,sort,direction));break;
			case "message" : pagee = this.taskExecutionRepository.findByMessageContaining(key,getPages(page,size,sort,direction));break;
			case "taskConfigName" : pagee = this.taskExecutionRepository.findByTaskConfigNameContaining(key,getPages(page,size,sort,direction));break;
			case "transportedFiles" : pagee = this.taskExecutionRepository.findByTransportedFilesContaining(key,getPages(page,size,sort,direction));break;
			default :
				pagee= this.taskExecutionRepository.findAll(getPages(page,size,sort,direction));
		}
		return pagee;
	}

	public Pageable getPages(String page,String size,String sort,String direction){
		Sort.Direction dir;
		if("asc".equals(direction)){
			dir= Sort.Direction.ASC;
		}else
			dir= Sort.Direction.DESC;
		return new PageRequest(Integer.parseInt(page),Integer.parseInt(size), dir, sort);
	}

}
