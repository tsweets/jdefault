package org.beer30.jdefault.sample;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.beer30.jdefault.*;


/**
 * @author tsweets
 *         Date: 2/21/14
 *         Time: 7:24 PM
 */
public class Example {

    public static void main(String[] args) {
        Person fakePerson = new Person();

        fakePerson.setFirstName(JDefaultName.firstName());
        fakePerson.setLastName(JDefaultName.lastName());
        fakePerson.setMiddleName(JDefaultName.middleName());
        fakePerson.setSuffix(JDefaultName.suffix());
        fakePerson.setAddress1(JDefaultAddress.streetAddress(true));
        fakePerson.setCity(JDefaultAddress.city());
        fakePerson.setState(JDefaultAddress.stateAbbr(false));
        fakePerson.setPostalCode(JDefaultAddress.zipCode());
        fakePerson.setSsn(JDefaultIdentity.ssn(true));
        fakePerson.setEmail(JDefaultInternet.safeEmail());
        fakePerson.setQuote(JDefaultLorem.sentence());
        fakePerson.setPhone(JDefaultPhoneNumber.phoneNumberFormatted());
        fakePerson.setEmployer(JDefaultCompany.name());
        fakePerson.setAge(Integer.toString(JDefaultNumber.randomIntBetweenTwoNumbers(18, 40)));

        System.out.println(fakePerson);
    }

    private static class Person {
        private String firstName;
        private String lastName;
        private String middleName;
        private String suffix;
        private String address1;
        private String address2;
        private String city;
        private String postalCode;
        private String state;
        private String ssn;
        private String email;
        private String quote;
        private String phone;
        private String employer;
        private String age;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmployer() {
            return employer;
        }

        public void setEmployer(String employer) {
            this.employer = employer;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

      /*  @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Person{");
            sb.append("firstName='").append(firstName).append('\'');
            sb.append(", lastName='").append(lastName).append('\'');
            sb.append(", middleName='").append(middleName).append('\'');
            sb.append(", suffix='").append(suffix).append('\'');
            sb.append(", address1='").append(address1).append('\'');
            sb.append(", address2='").append(address2).append('\'');
            sb.append(", city='").append(city).append('\'');
            sb.append(", postalCode='").append(postalCode).append('\'');
            sb.append(", state='").append(state).append('\'');
            sb.append(", ssn='").append(ssn).append('\'');
            sb.append(", email='").append(email).append('\'');
            sb.append(", quote='").append(quote).append('\'');
            sb.append(", phone='").append(phone).append('\'');
            sb.append(", employer='").append(employer).append('\'');
            sb.append(", age='").append(age).append('\'');
            sb.append('}');
            return sb.toString();
        }*/

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("firstName", firstName)
                    .append("lastName", lastName)
                    .append("middleName", middleName)
                    .append("suffix", suffix)
                    .append("address1", address1)
                    .append("address2", address2)
                    .append("city", city)
                    .append("postalCode", postalCode)
                    .append("state", state)
                    .append("ssn", ssn)
                    .append("email", email)
                    .append("quote", quote)
                    .append("phone", phone)
                    .append("employer", employer)
                    .append("age", age)
                    .toString();
        }
    }
}
