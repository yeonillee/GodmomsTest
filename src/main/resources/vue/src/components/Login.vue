<template>
    <div>
        TOKEN : {{token}}
        <div class="btn_container">
            <button id="kakao" onClick="location.href='/account/kakao'" />
        </div>
        <div class="btn_container">
            <button id="google" onClick="location.href='/account/google'" />
        </div>
    </div>
</template>

<script>
import axios from 'axios';
axios.defaults.baseURL = 'http://localhost:8080';

export default {
    name: 'Login',
    data() {
        return {
            token: null
        }
    },
    mounted() {
    },
    methods: {
        getToken: function() {
            axios.get('/account/token').then(res => this.token = res.data)
        }
    },
    created() {
        this.getToken()
    }
}
</script>

<style scoped>
    div.btn_container {
        align-items: center;
        width: 100%;
    }

    .btn_container button {
        width: 600px;
        height: 98px;
        
        border: none;
        background-size: contain;
        background-repeat: no-repeat;
        background-position: center center;
    }

    button#kakao {
        background-image: url(../assets/kakao_account_login_btn_large_wide.png);
    }

    button#google {
        background-image: url(../assets/btn_google_signin_light_normal_web@2x.png);
    }
</style>