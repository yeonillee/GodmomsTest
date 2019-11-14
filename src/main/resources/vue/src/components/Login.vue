<template>
    <div>
        <div class="btn_container">
            <div class="btn_area" id="kakao" onClick="location.href='/account/kakao'" >
                <div class="btn_logo"></div>
                <div class="btn_text">
                    <p>카카오 로그인</p>
                </div>
            </div>
        </div>
        <div class="btn_container">
            <div class="btn_area" id="google" onClick="location.href='/account/google'" >
                <div class="btn_logo"></div>
                <div class="btn_text">
                    <p>구글 로그인</p>
                </div>
            </div>
        </div>
        <div class="btn_container">
            <div class="btn_area" id="facebook" onClick="location.href='/account/facebook'" >
                <div class="btn_logo"></div>
                <div class="btn_text">
                    <p>페이스북 로그인</p>
                </div>
            </div>
        </div>
        <div class="btn_container">
            <div class="btn_area" id="naver" onClick="location.href='/account/naver'" >
                <div class="btn_logo"></div>
                <div class="btn_text">
                    <p>네이버 로그인</p>
                </div>
            </div>
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
        }
    },
    mounted() {
    },
    methods: {
    }
}
</script>

<style scoped>
    div.btn_container {
        align-items: center;
        width: 100%;
        padding: 20px;
    }

    .btn_container div.btn_area {
        width: 350px;
        height: 98px;
        
        margin: 0 auto;
        border: 1px solid;
        border-radius: 10px;
        box-shadow: 5px;  
        vertical-align: middle;
        cursor: pointer;
    }

    .btn_container div.btn_area div {
        float: left;
        vertical-align: middle;
        position: relative;
    }

    .btn_logo {
        width: 90px;
        height: 90px;
                
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
    }

    .btn_text {
        height: 90px;
        width: 200px;
        align-items: left;
        vertical-align: middle;        
    }

    .btn_text p {
        font-size: 25px;
        vertical-align: middle;
    }

    #kakao .btn_logo {        
        background-image: url(../assets/kakaolink_btn_medium.png);
    }

    #google .btn_logo {        
        background-image: url(../assets/btn_google_light_pressed_ios@3x.png);
    }

    #facebook .btn_logo {        
        background-image: url(../assets/f_logo_RGB-Blue_1024.png);
    }

    #naver .btn_logo {        
        background-image: url(../assets/NAVER_Icon_Green.png);
    }
</style>