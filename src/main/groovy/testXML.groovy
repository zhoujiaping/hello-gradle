//https://www.ibm.com/developerworks/cn/java/j-pg05199/index.html
def parse(String xml){
    def parser = new XmlParser()
    def services = []
    def beans = parser.parseText(xml)
    beans['dubbo:service'].each{
        def service = [:]
        service['interface'] = it['@interface']
        service['group'] = it['@group']
        service['ref']= it['@ref']
        services<<service
    }
    services
}

def xml = '''
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
xmlns:context="http://www.springframework.org/schema/context" xmlns:p="http://www.springframework.org/schema/p"
xsi:schemaLocation="
    http://www.springframework.org/schema/beans  http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
    http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd
">
    <dubbo:reference id="smsService" interface="a.b.c.d.SMSService" />
    <dubbo:reference id="mailService" interface="a.b.c.d.MailService"/>
</beans> 
'''

def beans = parse(xml)

println beans

