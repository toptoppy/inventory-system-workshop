package odds.training.inventory.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import odds.training.inventory.entity.ProductEntity
import odds.training.inventory.model.Product
import odds.training.inventory.repository.ProductInventoryRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProductInventoryServiceTest {
    private val mockProductInventoryRepository: ProductInventoryRepository = mockk()
    private val service = ProductInventoryService(mockProductInventoryRepository)

    @Test
    fun `should retrieve all products when get all product`() {
        // Given
        val productEntity = listOf(
            ProductEntity(
                id = "1",
                name = "item A",
                description = "A B C",
                price = 200.0,
                stock = 10
            ),
            ProductEntity(
                id = "2",
                name = "item B",
                description = "A B C",
                price = 100.0,
                stock = 10
            )
        )
        val expectedProducts = listOf(
            Product(id = "1", name = "item A"),
            Product(id = "2", name = "item B")
        )

        every { mockProductInventoryRepository.findAll() } returns productEntity

        // When
        val actualProducts = service.getAllProducts()

        // Then
        assertEquals(expectedProducts, actualProducts, "The retrieved products should match the expected products.")
        verify(exactly = 1) { mockProductInventoryRepository.findAll() }
    }
}