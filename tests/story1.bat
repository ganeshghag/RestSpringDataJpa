rem curl -i -X DELETE --user ganesh:password http://localhost:8090/trackee/1
rem curl -i -X DELETE --user ganesh:password http://localhost:8090/trackee/2
rem curl -i -X DELETE --user ganesh:password http://localhost:8090/trackee/3


rem add ganesh as trackee
curl -i -X POST -H "Content-Type:application/json" ^
--user ganesh:password ^
-d {\"name\":\"ganesh\",\"latitude\":\"18.2736363\",\"longitude\":\"73.334648\",\"groupMembers\":\"\"} http://localhost:8090/trackee

rem add prachi as trackee
curl -i -X POST -H "Content-Type:application/json" ^
--user ganesh:password ^
-d {\"name\":\"prachi\",\"latitude\":\"18.2736363\",\"longitude\":\"73.334648\",\"groupMembers\":\"\"} http://localhost:8090/trackee

rem add janhavi as trackee
curl -i -X POST -H "Content-Type:application/json" ^
--user ganesh:password ^
-d {\"name\":\"janhavi\",\"latitude\":\"18.2736363\",\"longitude\":\"73.334648\",\"groupMembers\":\"\"} http://localhost:8090/trackee


rem add prachi as a friend to ganesh
curl -i -X POST -H "Content-Type:application/json" ^
--user ganesh:password ^
-d {\"id\":1,\"name\":\"ganesh\",\"latitude\":\"18.2736363\",\"longitude\":\"73.334648\",\"groupMembers\":\"prachi\"} http://localhost:8090/trackee


rem add janhavi as a friend to ganesh
curl -i -X POST -H "Content-Type:application/json" ^
--user ganesh:password ^
-d {\"id\":1,\"name\":\"ganesh\",\"latitude\":\"18.2736363\",\"longitude\":\"73.334648\",\"groupMembers\":\"prachi,janhavi\"} http://localhost:8090/trackee

rem get ganesh details
curl --user ganesh:password http://localhost:8090/trackee/search/findByName?name=ganesh

rem get ganesh friends details
curl --user ganesh:password http://localhost:8090/trackee/search/findByName?name=prachi

rem get ganesh friends details
curl --user ganesh:password http://localhost:8090/trackee/search/findByName?name=janhavi

