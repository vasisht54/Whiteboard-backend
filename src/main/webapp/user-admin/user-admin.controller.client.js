(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);
    function main() {
        findAllUsers();
    }

    $tbody = $("#svms-user-admin-table-body");

    let alice = {
        username: "alice",
        salary: 1234,
        tenured: true,
        role: "FACULTY"
    };

    let users = [];

    /*console.log(users);*/

    function findAllUsers() {
        userService.findAllUsers()
            .then(remoteUsers => {
                users = remoteUsers;
                renderUsers(users);
            });
    }

    function findUserById() {  }
    function deleteUser(index) {
        let user = users[index];
        console.log(user);
    }
    function selectUser() {  }
    function updateUser() {  }
    function renderUser(user) {  }



    function renderUsers(users) {
        for (let u in users) {
            $userRowTemplate = `<tr class="wbdv-template wbdv-user wbdv-hidden">
                            <td class="wbdv-username">${users[u].username}</td>
                              <td>${users[u].password}</td>
                              <td class="wbdv-first-name">${users[u].firstName}</td>
                              <td class="wbdv-last-name">${users[u].lastName}</td>
                              <td class="wbdv-role">${users[u].role}</td>
                              <td class="wbdv-actions">
                                <span class="float-right">
                                    <button class="btn">
                                        <i id="wbdv-delete" class="fa fa-times wbdv-remove"></i>
                                   </button>
                                    <button class="btn">
                                        <i id="wbdv-edit" class="fa fa-pencil wbdv-edit"></i>
                                   </button>
                                </span>
                              </td>
                         </tr>`;
           $tbody.append($userRowTemplate);
        }
    }
})();
