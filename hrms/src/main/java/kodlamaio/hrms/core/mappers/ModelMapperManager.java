package kodlamaio.hrms.core.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@Service//if you forget this you can encounter with ModelMapperService that could not be found.
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
	
	private ModelMapper modelMapper;

	
	  
	  
	@Override
	public ModelMapper forRequest() {
			 modelMapper.getConfiguration()
	         .setAmbiguityIgnored(true)
	         .setMatchingStrategy(MatchingStrategies.STANDARD);
	 return modelMapper;
	}

	@Override
	public ModelMapper forResponse() {
			  modelMapper.getConfiguration()
	          .setAmbiguityIgnored(true)
	          .setMatchingStrategy(MatchingStrategies.LOOSE);
	  return modelMapper;
	}



}
