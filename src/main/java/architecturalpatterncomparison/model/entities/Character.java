package architecturalpatterncomparison.model.entities;

public class Character {
	
	
	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private Planet origin;
	private Planet location;
	private String image;
	private String[] episode;
	private String url;
	private String created;
	
	
	
	
	
	
	
	
	
	
	/*
	{
		  "id": 2,
		  "name": "Morty Smith",
		  "status": "Alive",
		  "species": "Human",
		  "type": "",
		  "gender": "Male",
		  "origin": {
		    "name": "Earth",
		    "url": "https://rickandmortyapi.com/api/location/1"
		  },
		  "location": {
		    "name": "Earth",
		    "url": "https://rickandmortyapi.com/api/location/20"
		  },
		  "image": "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
		  "episode": [
		    "https://rickandmortyapi.com/api/episode/1",
		    "https://rickandmortyapi.com/api/episode/2",
		    // ...
		  ],
		  "url": "https://rickandmortyapi.com/api/character/2",
		  "created": "2017-11-04T18:50:21.651Z"
		}*/
	
	
	
	
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}










	public void setId(Integer id) {
		this.id = id;
	}










	public String getName() {
		return name;
	}










	public void setName(String name) {
		this.name = name;
	}










	public String getStatus() {
		return status;
	}










	public void setStatus(String status) {
		this.status = status;
	}










	public String getSpecies() {
		return species;
	}










	public void setSpecies(String species) {
		this.species = species;
	}










	public String getType() {
		return type;
	}










	public void setType(String type) {
		this.type = type;
	}










	public String getGender() {
		return gender;
	}










	public void setGender(String gender) {
		this.gender = gender;
	}










	public Planet getOrigin() {
		return origin;
	}










	public void setOrigin(Planet origin) {
		this.origin = origin;
	}










	public Planet getLocation() {
		return location;
	}










	public void setLocation(Planet location) {
		this.location = location;
	}










	public String getImage() {
		return image;
	}










	public void setImage(String image) {
		this.image = image;
	}










	public String[] getEpisode() {
		return episode;
	}










	public void setEpisode(String[] episode) {
		this.episode = episode;
	}










	public String getUrl() {
		return url;
	}










	public void setUrl(String url) {
		this.url = url;
	}










	public String getCreated() {
		return created;
	}










	public void setCreated(String created) {
		this.created = created;
	}










	public class Planet{
		private String name;
		private String url;
	    /* "name": "Earth",
	        "url": "https://rickandmortyapi.com/api/location/20"*/
		
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		
		
	} 
}
