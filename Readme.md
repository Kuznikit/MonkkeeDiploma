<h1 align="center"><img src="https://my.monkkee.com/assets/logo-f0892a4a253a67a010b482174e0e4a9f3d95eccc89e4c73422f09d6168df6b6b.png" /></h1>
<h1 align="center">Monkkee Diploma</h1>
<p align="center"><em><a title="monkkee" href="https://my.monkkee.com/#/"><span style="color: #ff6600;"><strong>Monkkee</strong></span></a>&nbsp;The safest place for your thoughts. Keep a private and free online diary</em></p>

<h3 dir="auto" align="left">Overview:</h3>
<p>&nbsp; &nbsp; &nbsp; &nbsp;At monkkee you can write private entries of all kinds, safely encrypted and protected from prying eyes. The secure online diary serves as a personal diary or journal, virtual notebook or storage location for spontaneous ideas and thoughts. In order to use monkkee all you need is an Internet connection. You can access your data from anywhere on the web.</p>

Clone the repository into your projects directory:
```
git clone git@github.com:panzerdp/clipboardy.git clipboardy-chrome-extension
```

# [$ git clone](https://github.com/Kuznikit/MonkkeeDiploma.git)

# Installation:
IDE: IntelliJ
Programming Language: JAVA (v.11.0)
Project Type: Maven
## Frameworks:
Selenium
TestNG
lombok
## Design Patterns used:
POM (Page Object Module)
# Logs
*log4j2
# Reporting:
Allure reporting system
### Global Usage

Global Registeration via Vue.use() method.

```js
// main.js
import Vue from "vue";
import App from "./App.vue";
import router from "./router";
// import the plugin
import Calendar from "vue2-baremetrics-calendar";

Vue.config.productionTip = false;

// use the plugin
Vue.use(Calendar);

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
```

Once registered you can use the component in its default settings with as follows:-

```html
<Calendar
  type="double"
  @rangeEdit="processDateRange()"
  elementName="doubleRangePicker"
/>

<Calendar
  type="single"
  @dateEdit="processDate()"
  elementName="singleRangePicker"
/>
```

**REMEMBER _elementName_ is the only required prop and it should be different for each datepicker in your component**

```html
<template>
  <div id="app">
    <Calendar
      @rangeEdit="processOutput"
      type="double"
      elementName="otherRangePicker"
    />

    <Calendar
      @dateEdit="processOutput"
      type="single"
      elementName="primaryRangePicker"
    />
  </div>
</template>

<script>
  import Calendar from "./components/Calendar";
  export default {
    components: {
      Calendar
    },
    methods: {
      processOutput(output) {
        console.log(output);
      }
    }
  };
</script>
```

# Events Emitted -

| Name       | Type   | Output                             | Description                      |
| ---------- | ------ | ---------------------------------- | -------------------------------- |
| `dateEdit` | double | [Timestamp(begin), Timestamp(end)] | Array of start date and end date |
| `dateEdit` | single | Timestamp                          | Selected date Timestamp          |

# Base Calendar Props

- **elementName** _\*required_ `[string]`
    - DOM object of the calendar div you're working on
- **earliest_date** `[date YYYY-MM-DD]`
    - The earliest date to show in the calendar
- **latest_date** `[date YYYY-MM-DD]`
    - The latest date to show in the calendar
- **format** `[object]`
    - Object containing formatting strings for.. you guessed it.. formatting your dates
  ```js
    format: {
      input: 'MMMM D, YYYY', // Format for the input fields
      jump_month: 'MMMM', // Format for the month switcher
      jump_year: 'YYYY' // Format for the year switcher
    }
  ```
- **days_array** `[array]`
    - Array of the 7 strings you'd like to represent your days in the calendar
  ```js
  days_array: ["S", "M", "T", "W", "T", "F", "S"];
  ```

### Single Calendar Props

- **current_date** `[date YYYY-MM-DD]`
    - The date to start the calendar on
- **required** `[boolean]`
    - Toggle if this field must have always have a valid selected date
- **placeholder** `[string]`
    - Set placeholder text (note this will only apply if the required key is set to `false`). The default will be whatever moment date format you're using. (i.e. 'M/D/YYYY')

### Double Calendar Props

- **start_date** `[date YYYY-MM-DD]`
    - The date to start the selection on for the calendar
- **end_date** `[date YYYY-MM-DD]`
    - The date to end the selection on for the calendar
- **same_day_range** `[boolean]`
    - Allow a range selection of a single day
- **format** `[preset key in format object] // see above`
    - The double calendar adds the `preset` key to the format object for formatting the preset dates in the preset dropdown
- **presets** `[boolean] or [object]`
    - If you don't want to show the preset link just set this to `false` otherwise the default is true which will just give you a basic preset of.. yep.. presets. BOOM!
    - Otherwise, if you want to customize it up you can include an array of preset objects. Something like:
  ```js
  presets: [
    {
      label: "Last month",
      start: moment()
        .subtract(1, "month")
        .startOf("month"),
      end: moment()
        .subtract(1, "month")
        .endOf("month")
    },
    {
      label: "Last year",
      start: moment()
        .subtract(1, "year")
        .startOf("year"),
      end: moment()
        .subtract(1, "year")
        .endOf("year")
    }
  ];
  ```
