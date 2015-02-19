# email-cmd-sender
Easy way for send email via command line

# Dependencies
```xml
<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>javax.mail</groupId>
			<artifactId>mail</artifactId>
			<version>1.4</version>
		</dependency>
		<dependency>
			<groupId>args4j</groupId>
			<artifactId>args4j</artifactId>
			<version>2.0.29</version>
		</dependency>
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.3.2</version>
		</dependency>
	</dependencies>
```

# Options

 -attach VAL     : Sets a attach path file * Not required
 <br/>
 -content VAL    : Sets a content
 <br/>
 -mail VAL       : Sets the mail
 <br/>
 -properties VAL : Properties path
 <br/>
 -subject VAL    : Sets a subject
 
# Note
 
 Please edit the email.properties with the smtp configuration.
 
mail.smtp.port=<br/>
mail.smtp.auth=<br/>
mail.smtp.starttls.enable=<br/>
mail.smtp.host=<br/>
mail.smtp.user=<br/>
mail.smtp.password=<br/>
