/**
* Recipe Puppy
* Recipe Puppy
*
* The version of the OpenAPI document: 1.0.0
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/

package util

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.EmptyCoroutineContext

internal actual fun <T> runTest(block: suspend CoroutineScope.() -> T): T = kotlinx.coroutines.runBlocking(EmptyCoroutineContext, block)