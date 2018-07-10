<template>
    <div class="booking">
        <h1>This is a booking page</h1>
        <date-picker></date-picker>
    </div>
</template>

<script>
    // @ is an alias to /src
    import DatePicker from '@/components/DatePicker.vue'

    export default {
        name: 'booking',
        components: {
            DatePicker
        }
    }
</script>
