package com.glovebox.functions

import com.glovebox.functions.models.*
import java.util.*
import com.microsoft.azure.functions.annotation.*
import com.microsoft.azure.functions.*
import com.google.gson.*


/**
 * Azure Functions with HTTP Trigger.
 */
class TheThingsNetwork {

    @FunctionName("TheThingsNetwork")
    fun run(
            @HttpTrigger(name = "req", methods = arrayOf(HttpMethod.POST), authLevel = AuthorizationLevel.FUNCTION) request: HttpRequestMessage<Optional<String>>,
            @EventHubOutput(name = "devicesEventHub", eventHubName = "devices", connection = "EventHubSenderCS") ttnOutData: OutputBinding<EnvironmentEntity>,
            context: ExecutionContext): HttpResponseMessage {

        val gson = GsonBuilder().create()
        val body = request.body.get()
        val ttn = gson.fromJson<TtnEntity>(body, TtnEntity::class.java)

        context.logger.info("Message received from device " + ttn.dev_id)

        val environment = EnvironmentEntity()
        environment.DeviceId = ttn.dev_id
        environment.Geo = ttn.dev_id
        environment.Id = ttn.counter

        environment.Celsius = ttn.payload_fields!!.getOrDefault(key="temperature_1", defaultValue = null)
        environment.hPa = ttn.payload_fields!!.getOrDefault(key="barometric_pressure_2", defaultValue = null)
        environment.Humidity = ttn.payload_fields!!.getOrDefault(key="relative_humidity_3", defaultValue = null)
        environment.Battery = ttn.payload_fields!!.getOrDefault(key="analog_in_4", defaultValue = null)

        ttnOutData.value = environment

        return request.createResponseBuilder(HttpStatus.OK).build()
    }
}