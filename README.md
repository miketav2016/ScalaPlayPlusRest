1. for run use  ```sbt run```
2. for test use get endPoint http://localhost:9000/ping or http://localhost:9000/resTest
3. for check work use post http://localhost:9000/searchTitle with body like

`  
{
	  "links": [
	  	"https://cdn.cookielaw.org/consent/c3d9f1e3-55f3-4eba-b268-46cee4c6789c/c3d9f1e3-55f3-4eba-b268-46cee4c6789c.json",
		"https://ot.gov.ru/api/mandatoryRequirement/b9426550-ec81-46d8-b8e1-6659811ddaa3"
	  ]
  } 
  `
