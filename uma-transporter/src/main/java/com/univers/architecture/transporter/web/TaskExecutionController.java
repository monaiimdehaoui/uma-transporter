/**
 * 
 */
package com.univers.architecture.transporter.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.univers.architecture.transporter.model.TaskExecution;
import com.univers.architecture.transporter.service.ITaskExecutionService;

/**
 * @author sabir
 *
 */
@RestController
@RequestMapping("/api")
public class TaskExecutionController {

	@Autowired
	private ITaskExecutionService taskExecutionService;

	@CrossOrigin
	@GetMapping("/taskExecution")
	public Page<TaskExecution> getAllTaskExecutions(@RequestParam("page") String page, @RequestParam("size") String size,
													@RequestParam("sort") String sort, @RequestParam("direction")String direction,
													@RequestParam("key") Optional<String> key , @RequestParam("filter") Optional<String> filter) {


		if(key.isPresent() && filter.isPresent())
			return this.taskExecutionService.searchInTaskExecution(page, size, sort, direction, key.get(), filter.get());
			return this.taskExecutionService.getAllTaskExecution(page,size,sort,direction);
	}
}
