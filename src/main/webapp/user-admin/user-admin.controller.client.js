(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);


    $tbody = $("#svms-user-admin-table-body");

    let users = [];

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
        userService.deleteUser(user._id)
            .then(response => {
                if(response.status === 200) {
                    findAllUsers();
                }
            });
    }

    function createUser() {

    }


    function selectUser() {  }
    function updateUser() {  }
    function renderUser(user) {  }


    function renderUsers(users) {
        $tbody.empty();
        for (let u in users) {
            $userRowTemplate = `<tr class="wbdv-template wbdv-user wbdv-hidden">
                            <td class="wbdv-username">${users[u].username}</td>
                              <td>${users[u].password}</td>
                              <td class="wbdv-first-name">${users[u].firstName}</td>
                              <td class="wbdv-last-name">${users[u].lastName}</td>
                              <td class="wbdv-role">${users[u].role}</td>
                              <td class="wbdv-actions">
                                <span class="float-right">
                                    <button id="svms-delete-user-${u}" class="btn">
                                        <i id="wbdv-delete" class="fa fa-times wbdv-remove"></i>
                                   </button>
                                    <button id="svms-edit-user-${u}" class="btn">
                                        <i id="wbdv-edit" class="fa fa-pencil wbdv-edit"></i>
                                   </button>
                                </span>
                              </td>
                         </tr>`;
            $tbody.append($userRowTemplate);
            document.getElementById(`svms-delete-user-${u}`)
                .addEventListener('click', () => deleteUser(u));
        }
    }

    function main() {
        findAllUsers();

        let $createUserBtn = $(".svms-create-user .wbdv-create");
        $createUserBtn.click(() => createUser());


    }
})();
