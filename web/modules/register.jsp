<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div id="register" class="modal">
    <div class="modal-content">
        <h4>Register</h4>
        <div class="row">
            <form class="col s12" action="register" method="post">
                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">person</i>
                        <input id="first_name" name="first_name"  type="text" maxlength="50" class="validate">
                        <label for="first_name">First Name</label>
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">person</i>
                        <input id="last_name" name="last_name"  type="text" maxlength="50" class="validate">
                        <label for="last_name">Last name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">perm_contact_calendar</i>
                        <input id="birth" name="birth"  type="text" class="datepicker">
                        <label for="birth">Birth Date</label>
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">location_on</i>
                        <input id="street" name="street"  type="text" maxlength="100" class="validate">
                        <label for="street">Street</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s4">
                        <i class="material-icons prefix">location_city</i>
                        <input id="city" name="city"  type="text" maxlength="50" class="validate">
                        <label for="city">City</label>
                    </div>
                    <div class="input-field col s2">
                        <input id="postal_code" name="street"  type="number" maxlength="5" class="validate">
                        <label for="postal_code">Postal Code</label>
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">business</i>
                        <select name="country">
                            <c:forEach items="${countries}" var="country">
                                <option value="${country.countryId}">${country.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">mail</i>
                        <input id="register_email" name="email"  type="email" maxlength="50" class="validate">
                        <label for="register_email">Email</label>
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">vpn_key</i>
                        <input id="register_password" name="password" type="password" maxlength="50">
                        <label for="register_password">Password</label>
                    </div>
                </div>
                <div class="row">
                    <a href="#!" class="modal-close waves-effect waves-green btn-flat">Close</a>
                    <button class="btn btn-large waves-effect waves-light right" type="submit" name="action">LOGIN
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>