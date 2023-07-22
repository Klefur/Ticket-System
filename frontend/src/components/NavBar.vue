<template>
    <nav class="navbar">
        <div class="brand logo-container">
            <router-link to="/" onclick="this.isLoggedIn = false" class="img1">
                    <img alt="Usach logo" src="@/assets/logo.svg" width="180" height="180" />
            </router-link>
        </div>

        <ul class="nav">
            <li v-if="!this.isLoggedIn">
                <router-link to="/login"> Login </router-link>
            </li>
            <li v-else>
                <router-link to="/" onclick="this.isLoggedIn = false"> Logout </router-link>
            </li>
        </ul>

    </nav>
</template>

<style scoped>
    .navbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 130px;
        padding: 0 2rem;
        background-color: #00a9a0;
    }

    .brand {
        display: flex;
        align-items: center;
    }

    a .img1::hover {
        transform: none;
    }

    .logo-container {
        margin-top: 1rem;
        margin-bottom: 1rem;
        width: 120px;
        height: 120px;
        padding: 0px;
        filter: invert(100%) sepia(4%) saturate(15%) hue-rotate(33deg) brightness(103%) contrast(106%);
    }

    a {
        text-decoration: none;
        color: #f9f9f9;
    }

    a:hover {
        color: #b0f9f9;
    }

</style>