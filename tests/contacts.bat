rem add ganesh as trackee
rem curl -i -X POST -H "Content-Type:application/json" -d {\"name\":\"ganesh\",\"mobile\":\"9920823827\",\"email\":\"ganes@email.com\",\"facebookLink\":\"http://some\",\"twitterLink\":\"http://some\",\"address\":\"addr1\",\"city\":\"Thane\",\"zipcode\":\"737673\",\"imageLink\":\"http://some\"} http://localhost:8090/contacts

rem curl -i -X POST -H "Content-Type:application/json" -d @contacts.json http://localhost:8090/contacts

curl -i -X POST -H "Content-Type:application/json" -d @contacts.json http://54.152.217.134:8090/contacts


