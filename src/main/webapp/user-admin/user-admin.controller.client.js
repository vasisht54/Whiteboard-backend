(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $okBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);


    $tbody = $("#svms-user-admin-table-body");

    let users = [];
    let selectedUserId;

    function findAllUsers() {
        userService.findAllUsers()
            .then(remoteUsers => {
                users = remoteUsers;
                renderUsers(users);
            });
    }

    function findUserById(_id) {
        return userService.findUserById(_id)
            .then(remoteUser => remoteUser
            );
    }


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
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $roleFld = $("#roleFld");

        const newUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        };
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("")

        userService.createUser(newUser)
            .then(brandNewUser => {
                findAllUsers();
            })
    }

    function selectUser() {

    }
    function updateUser() {
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $roleFld = $("#roleFld");

        const newUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        };
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("")

        userService.updateUser(selectedUserId, newUser)
            .then(brandNewUser => {
                findAllUsers();
            })
    }
    function renderUser(_id) {
        findUserById(_id)
            .then((selectedUser) => {
                selectedUserId = selectedUser._id;
                $usernameFld = $("#usernameFld");
                $passwordFld = $("#passwordFld");
                $firstNameFld = $("#firstNameFld");
                $lastNameFld = $("#lastNameFld");
                $roleFld = $("#roleFld");
                $usernameFld.val(selectedUser.username);
                $passwordFld.val(selectedUser.password);
                $firstNameFld.val(selectedUser.firstName);
                $lastNameFld.val(selectedUser.lastName);
                $roleFld.val(selectedUser.role);
            })
    }


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
                                            <i id="wbdv-remove" class="fa fa-times wbdv-remove"></i>
                                       </button>
                                        <button id="svms-edit-user-${u}" class="btn">
                                            <i id="wbdv-edit" class="fa fa-pencil wbdv-edit"></i>
                                       </button>
                                    </span>
                                  </td>
                                </tr>`;
            $tbody.append($userRowTemplate);
            $removeBtn = document.getElementById(`svms-delete-user-${u}`);
            $removeBtn.addEventListener('click', () => deleteUser(u));
            $editBtn = document.getElementById(`svms-edit-user-${u}`);
            $editBtn.addEventListener('click', () => renderUser(users[u]._id));
        }
    }

    function main() {
        findAllUsers();

        $createBtn = $(".svms-create-user .wbdv-create");
        $createBtn.click(() => createUser());

        $okBtn = $(".svms-update-user .wbdv-update");
        $okBtn.click(() => updateUser());
    }
})();
