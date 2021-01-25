package architecturalpatterncomparison.model.api;

import architecturalpatterncomparison.model.entities.Character;
import architecturalpatterncomparison.model.entities.CharacterInfoResult;
import feign.Param;
import feign.RequestLine;

public interface CharacterClient {

	    @RequestLine("GET /{id}")
		Character findById(@Param("id") Integer id);

	    @RequestLine("GET")
		CharacterInfoResult findAll();
/*
	    @RequestLine("POST")
	    @Headers("Content-Type: application/json")
	    void create(Book book);*/
	
}
