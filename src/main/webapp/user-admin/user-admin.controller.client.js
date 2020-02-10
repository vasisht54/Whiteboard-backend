(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);
    function main() { findAllUsers() }

    $tbody = $("#svms-user-admin-table-body");

    function findAllUsers() {
        userService.findAllUsers()
            .then(remoteUsers => {
                users = remoteUsers;
                for (let u in remoteUsers) {
                    $userRowTemplate = `<tr class="wbdv-template wbdv-user wbdv-hidden">
                                <td class="wbdv-username">${remoteUsers[u].username}</td>
                                  <td>${remoteUsers[u].password}</td>
                                  <td class="wbdv-first-name">${remoteUsers[u].firstName}</td>
                                  <td class="wbdv-last-name">${remoteUsers[u].lastName}</td>
                                  <td class="wbdv-role">${remoteUsers[u].role}</td>
                                  <td class="wbdv-actions">
                                    <span class="float-right">
                                      <button class="btn" id="userDelete-${u}">
                                            <i id="wbdv-remove" class="fa fa-times wbdv-remove"></i>
                                       </button>
                                      <button class="btn" id="userEdit-${u}">
                                            <i id="wbdv-edit" class="fa fa-pencil wbdv-edit"></i>
                                       </button>
                                    </span>
                                  </td>
                             </tr>`;
                    $tbody.append($userRowTemplate);
                }
            });

    }

        function findUserById() {  }
        function deleteUser() {
        }
        function selectUser() {  }
        function updateUser() {  }
        function renderUser(user) {  }
        function renderUsers(users) {  }
})();
