function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/001347476/users';
    var self = this;
    function createUser(user) {  }

    function findAllUsers() {
        return fetch(self.url)
            .then((response) => response.json());
    }

    function findUserById(userId) {  }
    function updateUser(userId, user) {  }
    function deleteUser(userId){}

}
