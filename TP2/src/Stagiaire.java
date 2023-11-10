public class Stagiaire {
    private String lastName;
    private String firstName;
    private String address;
    private String date;
    private String countryCode;
    private String birthCity;
    private String companyId;
    private String email;
    private String phone;
    private String lastNameAr;
    private String firstNameAr;
    private String birthCityAr;

    public Stagiaire(String lastName, String firstName, String address, String date, String countryCode,
                     String birthCity, String companyId, String email, String phone, String lastNameAr,
                     String firstNameAr, String birthCityAr) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.date = date;
        this.countryCode = countryCode;
        this.birthCity = birthCity;
        this.companyId = companyId;
        this.email = email;
        this.phone = phone;
        this.lastNameAr = lastNameAr;
        this.firstNameAr = firstNameAr;
        this.birthCityAr = birthCityAr;
    }

    // Getters
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastNameAr() {
        return lastNameAr;
    }

    public String getFirstNameAr() {
        return firstNameAr;
    }

    public String getBirthCityAr() {
        return birthCityAr;
    }

    // Setters
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastNameAr(String lastNameAr) {
        this.lastNameAr = lastNameAr;
    }

    public void setFirstNameAr(String firstNameAr) {
        this.firstNameAr = firstNameAr;
    }

    public void setBirthCityAr(String birthCityAr) {
        this.birthCityAr = birthCityAr;
    }

}
