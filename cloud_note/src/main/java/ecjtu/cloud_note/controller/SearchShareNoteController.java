package ecjtu.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import ecjtu.cloud_note.entity.Share;
import ecjtu.cloud_note.service.SearchShareNoteService;
import ecjtu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class SearchShareNoteController {
	@Resource
	private SearchShareNoteService searchService;
	
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult<List<Share>> execute(String keyword,int page){
		NoteResult<List<Share>> result = searchService.findShareNote(keyword,page);
		
		return result;
	}
}








