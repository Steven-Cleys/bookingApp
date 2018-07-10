<template>
    <div class="container">
        <date-picker v-model="dateValue" lang="en"></date-picker>

        <br/>
        <select v-if="dateValue" v-model="timeValue">
            <option :disabled="!time.isAvailable" v-bind:key="time.time" v-for="time in availableTimes"
                    :value="time.time">{{time.time | format}}
            </option>
        </select>
        <br/>
        <button :disabled="!timeValue || !dateValue" type="button" @click="book" class="btn btn-primary">Book</button>
        <br/>
        <div v-if="showAlert" class="alert alert-success" role="alert">
            Booking successful!
        </div>
    </div>
</template>

<script>
    import DatePicker from 'vue2-datepicker'
    import {getByDate, bookSlot} from '../api/api'
    import moment from 'moment'

    export default {
        components: {
            DatePicker
        },
        created: () => {
            console.log('Hi')
        },
        data() {
            return {
                dateValue: '',
                timeValue: '',
                showAlert: false,
                availableTimes: [
                    {time: 11, isAvailable: true},
                    {time: 12, isAvailable: true},
                    {time: 13, isAvailable: true},
                    {time: 14, isAvailable: true},
                    {time: 15, isAvailable: true},
                    {time: 16, isAvailable: true},
                    {time: 17, isAvailable: true},
                    {time: 18, isAvailable: true},
                    {time: 19, isAvailable: true},
                    {time: 20, isAvailable: true},
                    {time: 21, isAvailable: true},
                ]
            }
        },
        methods: {
            book: function () {
                const slot = {}
                slot.reservationName = 'test'
                slot.date = this.formatDate(this.dateValue)
                slot.timeFrom = this.timeValue + ':00'
                slot.timeTo = (this.timeValue + 1) + ':00'
                console.log(slot)
                bookSlot(slot).then(res => {
                    this.showAlert = true
                }).catch(function (error) {
                    console.log('Error ' + error)
                })
            },
            formatDate: function (date) {
                return moment(date).format('YYYY-MM-DD')
            }
        },

        watch: {
            dateValue: function (val) {
                this.timeValue = ''
                this.showAlert = false
                if (val) {
                    const formattedDate = this.formatDate(val)
                    console.log(formattedDate)
                    getByDate(formattedDate).then(
                        res => {
                            //get the reserved time slots
                            const reservedTimeResults = res.data.map(x => x.timeFrom)

                            //if already reserved set isAvailable to false
                            this.availableTimes.map(x => {
                                x.isAvailable = !reservedTimeResults.includes(x.time + ':00:00')
                                return x
                            })
                        }
                    )
                }
            }
        },
        filters: {
            format: function (val) {
                return val + ':00'
            }
        }
    }

</script>