jdefault
========

Java Default Data Library
-------------------------

A Port of ruby faker http://faker.rubyforge.org

Jdefault is a Java library used for generating fake data for test automation. For example it can be user to generate fake names,
addresses, credit card numbers, phone numbers, and many more items. The need for this library came from my own projects at work and
the need to use default data in my unit and integration tests. I did extensive searches and found Ruby Faker, however I needed something
written in Java.

I ended up including the Java Faker https://github.com/DiUS/java-faker lib into my project, but quickly found myself extending it
for my own needs. After about 6 months of using my highly extended version of Java Faker. I decided to create my own based on the work
of the Java and Ruby Faker projects. It is my goal to use the Ruby Faker dictionary (en.yml) as is as much as possible (I had to
tweak it a little bit) so that I can leverage that work plus language translations in the future. Three goals I had for this library
 over Java Faker were:

1. 100% Static
2. Extensible Architecture
3. Equivalent to the Ruby Faker API

To include, this dependncy to your pom
```xml
<dependency>
    <groupId>org.beer30</groupId>
    <artifactId>jdefault</artifactId>
    <version>1.0.0</version>
</dependency>
```

Example Usage
-------------

Running this code
```java
 import org.beer30.jdefault.Name;
 import org.beer30.jdefault.Number;
 import org.beer30.jdefault.Address;
 import org.beer30.jdefault.Identity;
 import org.beer30.jdefault.Internet;
 import org.beer30.jdefault.Lorem;
 import org.beer30.jdefault.PhoneNumber;
 import org.beer30.jdefault.Company;

 public static void main(String[] args) {
        Person fakePerson = new Person();

        fakePerson.setFirstName(Name.firstName());
        fakePerson.setLastName(Name.lastName());
        fakePerson.setMiddleName(Name.middleName());
        fakePerson.setSuffix(Name.suffix());
        fakePerson.setAddress1(Address.streetAddress(true));
        fakePerson.setCity(Address.city());
        fakePerson.setState(Address.stateAbbr(false));
        fakePerson.setPostalCode(Address.zipCode());
        fakePerson.setSsn(Identity.ssn(true));
        fakePerson.setEmail(Internet.safeEmail());
        fakePerson.setQuote(Lorem.sentence());
        fakePerson.setPhone(PhoneNumber.phoneNumberFormatted());
        fakePerson.setEmployer(Company.name());
        fakePerson.setAge(Integer.toString(Number.randomIntBetweenTwoNumbers(18,40)));

        System.out.println(fakePerson);
    }
```


Results in:

    org.beer30.jdefault.sample.Example$Person@a5c18ff[
        firstName=Alvera
        lastName=Leffler
        middleName=Sebastian
        suffix=DVM
        address1=8480 Kemmer Branch Apt. 244
        address2=<null>
        city=Jacobsfurt
        postalCode=41552
        state=GA
        ssn=446-01-7876
        email=bfahey63@example.net
        quote=Explicabo natus enim exercitationem et nulla enim.
        phone=1-347-270-5849
        employer=Mitchell Inc
        age=22
    ]



