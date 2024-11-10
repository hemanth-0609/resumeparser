# **Instructions**

**1. Clone the Repository**

https://github.com/hemanth-0609/resumeparser.git

**cd resumeparser**

**2. Set Up config.properties**
   The tech-words-config.properties file should contain a comma-separated list of technical terms and stop words. Ensure the file has the following structure:

**List of technical terms separated by commas**
technical.terms=java,microservices,spring,api,docker,kubernetes,cloud,aws,azure,gcp,sql,nosql,mongodb,database,devops,ci,cd,rest,soap,json,xml,jpa,hibernate,oauth,authentication,authorization,linux,unix,shell,bash,scripting,splunk,logging,monitoring,ansible,terraform,jenkins,git,github,bitbucket,cicd,nginx,apache,front-end,back-end,full-stack,react,angular,vue,html,css,javascript,typescript,node,express,webpack,babel,redux,bootstrap,material-ui,sass,less,npm,yarn,unit testing,integration testing,jest,mocha,chai,junit,pytest,selenium,cucumber,kafka,rabbitmq,message queue,data pipeline,event-driven,spark,hadoop,etl,lambda,s3,ec2,rds,dynamodb,sqs,sns,cloudformation,cloudwatch,elasticsearch,redis,memcached,mysql,postgresql,sqlite,sql server,load balancing,api gateway,swagger,openapi,graphql,mvc,mvc pattern,design pattern,tdd,bdd,agile,scrum,kanban,jira,confluence,performance tuning,scalability,load testing,unit test,integration test

**List of stop words separated by commas**
stop.words=the,and,is,in,it,of,to,for,with,a,an,on,this,that,by,as,from,at,be,has,have,or,but,not,are,was,were

**3. Import the Project into IntelliJ IDEA**

   Open IntelliJ IDEA.

   Select File > New > Project from Existing Sources….

   Select the directory containing the TechnicalWordCounter.java file.

   Select Import Project from External Model and choose IntelliJ IDEA.

   Complete the setup, ensuring that the correct JDK is selected (e.g., JDK 17 or above).

**4. Running the Application**

   To run the program, you need to specify the path to a resume file (e.g., hemanth_resume.txt) as an argument.

In IntelliJ IDEA, right-click on TechnicalWordCounter.java and select Run 'Main.main()'.

**Pass Arguments:**

Go to Run > Edit Configurations….

In the Program Arguments field, type resume.txt.

Click Apply and OK.

**5. Example Output**

   The program will output each unique technical word in resume.txt along with its count, like so:

kubernetes: 9

redux: 1

css: 3

cucumber: 2

mocha: 1

express: 1

react: 1

microservices: 14

spring: 46


**6. Testing**

   You can test the program by creating or modifying hemanth_resume.txt with various words and checking the counts based on the terms defined in tech-words-config.properties.