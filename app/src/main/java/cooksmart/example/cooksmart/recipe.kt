package cooksmart.example.cooksmart

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.example.dutyleavemanagmentsystem.R
import org.json.JSONObject
import java.time.LocalDate
import java.time.Month
import java.util.*


class recipe : Fragment() {
    @SuppressLint("MissingInflatedId")
    private lateinit var myFragment: MyFragment
    private lateinit var timePicker: TimePicker

    private lateinit var alarmManager: AlarmManager
    private lateinit var alarmIntent: PendingIntent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_recipe, container, false)
        // making the variable for setting the text inside the evnent 1 container

        var event1name = v.findViewById<TextView>(R.id.event1Name)
        var event1description = v.findViewById<TextView>(R.id.event1Description)
        var event1DateTime = v.findViewById<TextView>(R.id.event1DateTime)
        var select_data = v.findViewById<Button>(R.id.datepicker)
        var ShowAll = v.findViewById<Button>(R.id.show_all)


        // making the variable for setting the text inside the evnent 2 container

        var event2name = v.findViewById<TextView>(R.id.event2Name)
        var event2description = v.findViewById<TextView>(R.id.event2Description)
        var event2DateTime = v.findViewById<TextView>(R.id.event2DateTime)

        // making the variable for setting the text inside the evnent 3 container

        var event3name = v.findViewById<TextView>(R.id.event3Name)
        var event3description = v.findViewById<TextView>(R.id.event3Description)
        var event3DateTime = v.findViewById<TextView>(R.id.event3DateTime)

        // making the variable for setting the text inside the evnent 4 container

        var event4name = v.findViewById<TextView>(R.id.event4Name)
        var event4description = v.findViewById<TextView>(R.id.event4Description)
        var event4DateTime = v.findViewById<TextView>(R.id.event4DateTime)

        // making the variable for setting the text inside the evnent 5 container

        var event5name = v.findViewById<TextView>(R.id.event5Name)
        var event5description = v.findViewById<TextView>(R.id.event5Description)
        var event5DateTime = v.findViewById<TextView>(R.id.event5DateTime)

        // making the variable for setting the text inside the evnent 6 container

        var event6name = v.findViewById<TextView>(R.id.event6Name)
        var event6description = v.findViewById<TextView>(R.id.event6Description)
        var event6DateTime = v.findViewById<TextView>(R.id.event6DateTime)

        // making the variable for buttons for event containers





        var event1container = v.findViewById<LinearLayout>(R.id.event1maincontainer)
        var event2container = v.findViewById<LinearLayout>(R.id.event2maincontainer)
        var event3container = v.findViewById<LinearLayout>(R.id.event3maincontainer)
        var event4container = v.findViewById<LinearLayout>(R.id.event4maincontainer)
        var event5container = v.findViewById<LinearLayout>(R.id.event5maincontainer)
        var event6container = v.findViewById<LinearLayout>(R.id.event6maincontainer)

        //makeing the datepicker for selecting the date
        select_data.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog =
                DatePickerDialog(requireContext(), { _, year, monthOfYear, dayOfMonth ->
                    val specificDate1 = LocalDate.of(2023, Month.APRIL, 27)
                    val specificDate2 = LocalDate.of(2023, Month.APRIL, 29)
                    val specificDate3 = LocalDate.of(2023, Month.MAY, 1)
                    val specificDate4 = LocalDate.of(2023, Month.APRIL, 3)

                    var selectedDate = LocalDate.of(year, monthOfYear + 1, dayOfMonth)


                    if (selectedDate == specificDate1) {
                        event1container.visibility = View.VISIBLE
                        event2container.visibility = View.GONE
                        event3container.visibility = View.GONE
                        event4container.visibility = View.GONE
                        event5container.visibility = View.VISIBLE
                        event6container.visibility = View.GONE
                        ShowAll.visibility = View.VISIBLE
                    }

                    if (selectedDate == specificDate2) {
                        event1container.visibility = View.GONE
                        event2container.visibility = View.VISIBLE
                        event3container.visibility = View.GONE
                        event4container.visibility = View.GONE
                        event5container.visibility = View.GONE
                        event6container.visibility = View.GONE
                        ShowAll.visibility = View.VISIBLE
                    }

                    if (selectedDate == specificDate3) {
                        event1container.visibility = View.GONE
                        event2container.visibility = View.GONE
                        event3container.visibility = View.VISIBLE
                        event4container.visibility = View.GONE
                        event5container.visibility = View.GONE
                        event6container.visibility = View.VISIBLE
                        ShowAll.visibility = View.VISIBLE
                    }

                    if (selectedDate == specificDate4) {
                        event1container.visibility = View.GONE
                        event2container.visibility = View.GONE
                        event3container.visibility = View.GONE
                        event4container.visibility = View.VISIBLE
                        event5container.visibility = View.GONE
                        event6container.visibility = View.GONE
                        ShowAll.visibility = View.VISIBLE
                    }

                }, year, month, day)
            datePickerDialog.show()
        }

        ShowAll.setOnClickListener {
            event1container.visibility = View.VISIBLE
            event2container.visibility = View.VISIBLE
            event3container.visibility = View.VISIBLE
            event4container.visibility = View.VISIBLE
            event5container.visibility = View.VISIBLE
            event6container.visibility = View.VISIBLE
            ShowAll.visibility = View.GONE
        }

        //setting the values inside the event containers
        event1name.setText("Ingredients".toUpperCase())
        event1description.setText("1 pound pizza dough\n" +
                "1/2 cup tomato sauce\n" +
                "2  cheese\n" +
                "1/4  black olives\n" +
                "1/4  pepperoni\n" +
                "1/4  bell pepper\n" +
                "1/4 cup onion\n"
               )
        event1DateTime.setText("27-04-2023  9:30 AM ")

        event2name.setText("Ingredients".toUpperCase())
        event2description.setText("1 lb ground beef \n" +
                "4 hamburger buns\n" +
                "4 slices of cheese \n" +
                "4 leaves of lettuce\n" +
                "4 slices of tomato\n" +
                "1/2 cup of sliced onion\n" )
        event2DateTime.setText("29-04-2023  12:30 PM ")

        event3name.setText("Ingredients".toUpperCase())
        event3description.setText("2 cups basmati rice\n" +
                "4 cups water\n" +
                "1/2 cup plain yogurt\n" +
                "1 teaspoon turmeric powder\n" +
                "1 teaspoon cumin powder\n" +
                "1 teaspoon coriander powder\n" +
                "1/4 cup  oil\n"
                )
        event3DateTime.setText("1-05-2023  1:30 PM ")

        event4name.setText("Ingredients".toUpperCase())
        event4description.setText("4 cups whole milk\n" +
                "1/4 cup white vinegar\n" +
                "4 cups water\n" +
                "2 cups granulated sugar\n" +
                "4 cups ice cubes\n" +
                "1 teaspoon rose water")
        event4DateTime.setText("3-05-2023  8:30 AM ")

        event5name.setText("Ingredients".toUpperCase())
        event5description.setText("1 pound spaghetti\n" +
                "1 tablespoon olive oil\n" +
                "3 cloves garlic, minced\n" +
                "1 teaspoon dried basil\n" +
                "1 teaspoon dried oregano\n" +
                "1/4 teaspoon black pepper\n" +
                "1/2 cup red wine\n")
        event5DateTime.setText("27-04-2023  9:30 AM ")

        event6name.setText("Ingredients".toUpperCase())
        event6description.setText("4 cups of milk\n" +
                "3 tablespoons of lemon juice\n" +
                "1/2 cup of sugar\n" +
                "1/2 teaspoon of cardamom powder\n" +
                "1/4 cup of chopped pistachios for garnish (optional)")
        event6DateTime.setText("1-05-2023  9:30 AM ")







        //        for details container

        var backbtn = v.findViewById<Button>(R.id.backbutton)
        val container1 = v.findViewById<LinearLayout>(R.id.container1)
        val container2 = v.findViewById<RelativeLayout>(R.id.container2)
        var fragment_containers = v.findViewById<LinearLayout>(R.id.Fragment_Container)

        var detailsbtn1 = v.findViewById<Button>(R.id.details)
        var detailsbtn2 = v.findViewById<Button>(R.id.details2)
        var detailsbtn3 = v.findViewById<Button>(R.id.details3)
        var detailsbtn4 = v.findViewById<Button>(R.id.details4)
        var detailsbtn5 = v.findViewById<Button>(R.id.details5)
        var detailsbtn6 = v.findViewById<Button>(R.id.details6)




        detailsbtn1.setOnClickListener {
            container1.visibility = View.GONE
            container2.visibility = View.GONE

            myFragment =
                childFragmentManager.findFragmentById(R.id.fragment_container) as MyFragment
            fragment_containers.visibility = View.VISIBLE

            // Call the function to update the TextViews
            myFragment.updateTextViews(
                "Pizza Recipe",
                "Preheat your oven to 450°F (230°C).\n" +
                        "Roll out the pizza dough on a floured surface to your desired thickness and shape.\n" +
                        "Place the dough on a lightly oiled pizza pan or baking sheet.\n" +
                        "Brush the olive oil over the surface of the dough to prevent it from getting soggy.\n" +
                        "Spread the tomato sauce evenly over the dough, leaving a 1/2-inch border around the edges.\n" +
                        "Sprinkle the shredded mozzarella cheese over the sauce.\n" +
                        "Add your desired toppings, distributing them evenly over the cheese.\n" +
                        "Season the pizza with salt and pepper to taste.\n" +
                        "Bake in the preheated oven for 10-12 minutes or until the crust is golden brown and the cheese is melted and bubbly.\n" +
                        "Remove the pizza from the oven and let it cool for a few minutes before slicing and serving.\n" +
                        "Enjoy your homemade pizza!\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n"
            )
        }

        detailsbtn2.setOnClickListener {
            container1.visibility = View.GONE
            container2.visibility = View.GONE

            myFragment =
                childFragmentManager.findFragmentById(R.id.fragment_container) as MyFragment
            fragment_containers.visibility = View.VISIBLE

            // Call the function to update the TextViews
            myFragment.updateTextViews(
                "Burger recipe",
                "Preheat a grill or a grill pan over medium-high heat.\n" +
                        "Divide the ground beef into 4 equal portions and shape each portion into a patty that is about 1/2-inch thick.\n" +
                        "Season both sides of each patty with salt and pepper.\n" +
                        "Grill the patties for 3-4 minutes on each side or until they are cooked to your desired level of doneness.\n" +
                        "During the last minute of cooking, place a slice of cheese on top of each patty and allow it to melt.\n" +
                        "Toast the hamburger buns on the grill or in a toaster.\n" +
                        "Assemble the burgers by placing a lettuce leaf and a slice of tomato on the bottom bun, followed by the cooked patty with melted cheese, and a handful of sliced onion.\n" +
                        "Add any other toppings you desire, such as ketchup, mustard, mayonnaise, or pickles.\n" +
                        "Top with the other half of the bun and serve immediately.\n" +
                        "Enjoy your homemade cheeseburger!"
            )
        }

        detailsbtn3.setOnClickListener {
            container1.visibility = View.GONE
            container2.visibility = View.GONE

            myFragment =
                childFragmentManager.findFragmentById(R.id.fragment_container) as MyFragment
            fragment_containers.visibility = View.VISIBLE

            // Call the function to update the TextViews
            myFragment.updateTextViews(
                "Biryani Recipe ",
                "Rinse the basmati rice in cold water until the water runs clear. Soak the rice in cold water for 30 minutes.\n" +
                        "In a bowl, mix together the chicken, yogurt, ginger paste, garlic paste, turmeric powder, cumin powder, coriander powder, garam masala, and salt. Cover the bowl and marinate in the refrigerator for at least 1 hour, or overnight.\n" +
                        "In a large pot, bring the 4 cups of water to a boil. Drain the soaked rice and add it to the pot. Cook for 5-7 minutes or until the rice is partially cooked. Drain the rice and set it aside.\n" +
                        "In a large skillet or pot, heat the vegetable oil over medium-high heat. Add the sliced onions and cook for 5-7 minutes or until they are caramelized and golden brown. Remove the onions from the pot and set them aside.\n" +
                        "In the same pot, add the marinated chicken and cook for 10-12 minutes or until it is cooked through. Remove the chicken from the pot and set it aside.\n" +
                        "Layer the partially cooked rice on top of the caramelized onions in the pot. Add the cooked chicken on top of the rice. Sprinkle the raisins, almonds, and cilantro leaves over the chicken.\n" +
                        "Cover the pot with a tight-fitting lid and place it on the stove over low heat. Cook for 25-30 minutes or until the rice is fully cooked and fluffy.\n" +
                        "Use a fork to fluff the rice and mix in the chicken and caramelized onions. Serve hot.\n" +
                        "Enjoy your homemade chicken biryani!"
            )
        }

        detailsbtn4.setOnClickListener {
            container1.visibility = View.GONE
            container2.visibility = View.GONE

            myFragment =
                childFragmentManager.findFragmentById(R.id.fragment_container) as MyFragment
            fragment_containers.visibility = View.VISIBLE

            // Call the function to update the TextViews
            myFragment.updateTextViews(
                "Rasgulla recipe",
                "In a large pot, bring the milk to a boil over medium-high heat. Stir the milk constantly to prevent it from scorching.\n" +
                        "Once the milk comes to a boil, reduce the heat to low and add the lemon juice or white vinegar. Stir the milk gently and let it curdle for 1-2 minutes. The curdled milk should separate into solid white curds and a yellowish-greenish liquid called whey.\n" +
                        "Turn off the heat and let the curdled milk rest for 5 minutes.\n" +
                        "Line a colander with a cheesecloth and pour the curdled milk through it. The cheesecloth will catch the curds while the whey will drain out. Rinse the curds with cold water to remove any trace of lemon juice or vinegar.\n" +
                        "Gather the ends of the cheesecloth and twist it to squeeze out the excess whey. Hang the cheesecloth with the curds for 30 minutes to remove any remaining whey.\n" +
                        "After 30 minutes, transfer the curds to a large mixing bowl and knead them into a smooth and soft dough. You can use your palms to knead the curds or use a food processor.\n" +
                        "Divide the dough into small lemon-sized balls and shape them into smooth round balls without any cracks.\n" +
                        "In a large pot, bring 4 cups of water and 2 cups of granulated sugar to a boil. Stir the sugar until it dissolves completely.\n" +
                        "Gently add the rasgulla balls to the boiling sugar syrup. Cover the pot with a lid and cook for 15-20 minutes over medium-high heat. The rasgullas will puff up and double in size while cooking.\n" +
                        "Add 4 cups of ice cubes to the pot and cook for another 5 minutes. The sudden change in temperature will help to set the texture of the rasgullas.\n" +
                        "Turn off the heat and let the rasgullas cool in the syrup for at least 30 minutes.\n" +
                        "Add 1 teaspoon of rose water to the syrup for flavor (optional).\n" +
                        "Serve the rasgullas chilled, garnished with chopped nuts or edible silver foil (varakh).\n" +
                        "Enjoy your homemade rasgulla!"
            )
        }

        detailsbtn5.setOnClickListener {
            container1.visibility = View.GONE
            container2.visibility = View.GONE

            myFragment =
                childFragmentManager.findFragmentById(R.id.fragment_container) as MyFragment
            fragment_containers.visibility = View.VISIBLE

            // Call the function to update the TextViews
            myFragment.updateTextViews(
                "Pasta Recipe ",
                "Cook the spaghetti according to the package instructions until it is al dente. Drain and set it aside.\n" +
                        "In a large pot or Dutch oven, heat the olive oil over medium-high heat. Add the ground beef and cook until it is browned, breaking it up with a wooden spoon as it cooks.\n" +
                        "Add the onion and garlic to the pot and cook until the onion is translucent, about 5 minutes.\n" +
                        "Add the dried basil, dried oregano, salt, and black pepper to the pot and stir to combine.\n" +
                        "Add the crushed tomatoes, tomato paste, and red wine to the pot and stir to combine. Reduce the heat to low and let the sauce simmer for 20-30 minutes, stirring occasionally, until it thickens and the flavors meld together.\n" +
                        "Taste the sauce and adjust the seasoning as needed.\n" +
                        "Add the cooked spaghetti to the pot with the sauce and toss to coat the pasta in the sauce.\n" +
                        "Serve the spaghetti with meat sauce in individual bowls or plates, topped with grated Parmesan cheese and fresh parsley, if desired.\n" +
                        "Enjoy your homemade spaghetti with meat sauce!"
            )
        }

        detailsbtn6.setOnClickListener {
            container1.visibility = View.GONE
            container2.visibility = View.GONE

            myFragment =
                childFragmentManager.findFragmentById(R.id.fragment_container) as MyFragment
            fragment_containers.visibility = View.VISIBLE

            // Call the function to update the TextViews
            myFragment.updateTextViews(
                "Sandesh Recipe",
                "In a large pot, bring 4 cups of milk to a boil over medium-high heat. Stir the milk occasionally to prevent it from scorching.\n" +
                        "Once the milk comes to a boil, reduce the heat to low and add 3 tablespoons of lemon juice. Stir the milk gently and let it curdle for 1-2 minutes. The curdled milk should separate into solid white curds and a yellowish-greenish liquid called whey.\n" +
                        "Turn off the heat and let the curdled milk rest for 5 minutes.\n" +
                        "Line a colander with a cheesecloth and pour the curdled milk through it. The cheesecloth will catch the curds while the whey will drain out. Rinse the curds with cold water to remove any trace of lemon juice.\n" +
                        "Gather the ends of the cheesecloth and twist it to squeeze out the excess whey. Hang the cheesecloth with the curds for 30 minutes to remove any remaining whey.\n" +
                        "After 30 minutes, transfer the paneer to a large mixing bowl and knead it until it becomes smooth and soft. You can use your palms to knead the paneer or use a food processor.\n" +
                        "Add the sugar and cardamom powder to the paneer and knead it again until the sugar dissolves and the mixture becomes smooth and pliable.\n" +
                        "Heat a non-stick pan over medium heat and add the paneer mixture to it. Cook the mixture for 8-10 minutes, stirring constantly to prevent it from sticking to the pan.\n" +
                        "Turn off the heat and let the mixture cool down for 5-10 minutes.\n" +
                        "Take small portions of the paneer mixture and roll them into small balls or flatten them into different shapes as desired.\n" +
                        "Garnish each sandesh with chopped pistachios (optional) and refrigerate for at least 30 minutes before serving.\n" +
                        "Enjoy your homemade Sandesh!"
            )
        }

        backbtn.setOnClickListener {
            fragment_containers.visibility = View.GONE
            container1.visibility = View.VISIBLE
            container2.visibility = View.VISIBLE
        }


//        writing the code setting the alarm
        timePicker = v.findViewById(R.id.timePicker)
        var alarmbtn1 = v.findViewById<Button>(R.id.setalarm1)
        var alarmbtn2 = v.findViewById<Button>(R.id.setalarm2)
        var alarmbtn3 = v.findViewById<Button>(R.id.setalarm3)
        var alarmbtn4 = v.findViewById<Button>(R.id.setalarm4)
        var alarmbtn5 = v.findViewById<Button>(R.id.setalarm5)
        var alarmbtn6 = v.findViewById<Button>(R.id.setalarm6)

        // Get the AlarmManager service
        alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // Create an intent to start the alarm receiver
        val intent = Intent(context, AlarmReceiver::class.java)
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        alarmbtn1.setOnClickListener{

             val calendar = Calendar.getInstance()
             val hour = calendar.get(Calendar.HOUR_OF_DAY)
             val minute = calendar.get(Calendar.MINUTE)
             val timePickerDialog = TimePickerDialog(
                 requireContext(),
                 TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                     // Set the alarm using the selected time
                     calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                     calendar.set(Calendar.MINUTE, minute)
                     calendar.set(Calendar.SECOND, 0)
                     alarmManager.setExact(
                         AlarmManager.RTC_WAKEUP,
                         calendar.timeInMillis,
                         alarmIntent
                     )
                 },
                 hour,
                 minute,
                 false
             )
             timePickerDialog.show()
         }

        alarmbtn2.setOnClickListener{

            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    // Set the alarm using the selected time
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    calendar.set(Calendar.MINUTE, minute)
                    calendar.set(Calendar.SECOND, 0)
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        calendar.timeInMillis,
                        alarmIntent
                    )
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }


        alarmbtn3.setOnClickListener{

            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    // Set the alarm using the selected time
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    calendar.set(Calendar.MINUTE, minute)
                    calendar.set(Calendar.SECOND, 0)
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        calendar.timeInMillis,
                        alarmIntent
                    )
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }

        alarmbtn4.setOnClickListener{

            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    // Set the alarm using the selected time
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    calendar.set(Calendar.MINUTE, minute)
                    calendar.set(Calendar.SECOND, 0)
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        calendar.timeInMillis,
                        alarmIntent
                    )
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }


        alarmbtn5.setOnClickListener{

            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    // Set the alarm using the selected time
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    calendar.set(Calendar.MINUTE, minute)
                    calendar.set(Calendar.SECOND, 0)
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        calendar.timeInMillis,
                        alarmIntent
                    )
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }



        alarmbtn6.setOnClickListener{

            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    // Set the alarm using the selected time
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    calendar.set(Calendar.MINUTE, minute)
                    calendar.set(Calendar.SECOND, 0)
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        calendar.timeInMillis,
                        alarmIntent
                    )
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }





        return v
    }


    fun onRegisterButtonClick(button:Button) {

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Do you want to register this event?")
        builder.setMessage("you will get dl for this event")
        builder.setIcon(R.drawable.ic_info)
        addDutyLeave()

        builder.setPositiveButton("Yes") { dialogInterface, which ->
            // Show notification
            context?.let {
                val notificationManager = it.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val channelId = "my_channel_id"
                val notificationBuilder = NotificationCompat.Builder(it, channelId)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentTitle("Event Registered")
                    .setContentText("You have successfully registered for the event.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(
                        channelId,
                        "My Channel",
                        NotificationManager.IMPORTANCE_DEFAULT
                    )
                    notificationManager.createNotificationChannel(channel)
                }

                notificationManager.notify(1, notificationBuilder.build())
            }
        }

        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(context, "clicked No", Toast.LENGTH_LONG).show()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

    fun onDeregisterdButtonClick(button:Button) {

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Do you want to Deregister for this event?")
        builder.setMessage("you will get not get any dl for this event")
        builder.setIcon(R.drawable.ic_info)

        removeDutyLeave()

        builder.setPositiveButton("Yes") { dialogInterface, which ->

            // Show notification
            context?.let {
                val notificationManager = it.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val channelId = "my_channel_id"
                val notificationBuilder = NotificationCompat.Builder(it, channelId)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentTitle("Event Deregistered ")
                    .setContentText("You have successfully deregstered for the event.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(
                        channelId,
                        "My Channel",
                        NotificationManager.IMPORTANCE_DEFAULT
                    )
                    notificationManager.createNotificationChannel(channel)
                }

                notificationManager.notify(1, notificationBuilder.build())
            }
        }

        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(context, "clicked No", Toast.LENGTH_LONG).show()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun addDutyLeave(){
        val sharedPreferences = requireContext().getSharedPreferences("userRefs", Context.MODE_PRIVATE)
        val res = sharedPreferences.getString("userData", null)
        if (res != null) {
            var json= JSONObject(res)

            json.put("dl",json.getInt("dl")+1)
            json.put("total_classes",json.getInt("total_classes")+1)

            val editor = sharedPreferences.edit()
            editor.putString("userData", json.toString())
            editor.apply()
        }
    }

    fun removeDutyLeave(){
        val sharedPreferences = requireContext().getSharedPreferences("userRefs", Context.MODE_PRIVATE)
        val res = sharedPreferences.getString("userData", null)
        if (res != null) {
            var json= JSONObject(res)

            json.put("dl",json.getInt("dl"))
            json.put("total_classes",json.getInt("total_classes")-1)

            val editor = sharedPreferences.edit()
            editor.putString("userData", json.toString())
            editor.apply()

        }
    }

}