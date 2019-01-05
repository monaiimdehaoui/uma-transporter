/**
 * 
 */
package com.univers.architecture.transporter.service;

import java.util.List;

import com.univers.architecture.transporter.model.TaskExecution;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author sabir
 *
 */
public interface ITaskExecutionService {

	Page<TaskExecution> getAllTaskExecution(String page,String size,String sort,String direction);
	Page<TaskExecution> searchInTaskExecution(String page,String size,String sort,String direction,String key,String filter);

}
