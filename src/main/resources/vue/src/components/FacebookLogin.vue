<template>
    <div>
        <input value="+1" id="country_code" />
        <input placeholder="phone number" id="phone_number"/>
        <button v-on:click="smsLogin">Login via SMS</button>
        <div>OR</div>
        <input placeholder="email" id="email"/>
        <button v-on:click="emailLogin">Login via Email</button>
    </div>
</template>

<script>
export default {
    name: 'FacebookLogin',
    data() {
        return {
            
        }
    },
    mounted() {
        let sdkScript = document.createElement('script')
        sdkScript.setAttribute('src', 'https://sdk.accountkit.com/en_US/sdk.js')
        document.head.appendChild(sdkScript)
    },
    methods: {
        smsLogin: function() {
            alert('sms!!!!!!');
        },
        emailLogin: function() {
            alert('email!!!!!');
        }
    }
}
</script>

<style scoped>

</style>