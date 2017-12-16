package duel

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TaskProviderTest {
  private val provider = new TaskProvider()

  @Test def shouldReturnNotNull(): Unit =
    assertNotNull(provider.get(5))
}