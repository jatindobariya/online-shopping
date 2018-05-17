package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		category.setName("T.V");
		category.setDescription("This is TV DESCRIPTION");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside a table!", true,categoryDAO.add(category));
		
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(2);
		
		assertEquals("Successfully fetched the single category from the table","T.V",category.getName());
	}*/
	
	/*@Test
	public void testUpdatetCategory() {
		
		category = categoryDAO.get(2);
		category.setName("TV");
		
		assertEquals("Successfully update the single category in the table",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(2);
		
		assertEquals("Successfully delete the single category in the table",true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory() {
			
		assertEquals("Successfully fetch list of category from the table",1,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory() {
		
		//ADD Operation
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is Laptop DESCRIPTION");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added a category inside a table!", true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is TV DESCRIPTION");
		category.setImageURL("CAT_1.png");
		
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is Mobile DESCRIPTION");
		category.setImageURL("CAT_3.png");
		
		
		assertEquals("Successfully added a category inside a table!", true,categoryDAO.add(category));
		
		//fetching and updating category
		category = categoryDAO.get(2);
		category.setName("TV");
		
		assertEquals("Successfully update the single category in the table",true,categoryDAO.update(category));
		
		//delete the category
		assertEquals("Successfully delete the single category in the table",true,categoryDAO.delete(category));
		
		//list the category
		assertEquals("Successfully fetch list of category from the table",1,categoryDAO.list().size());
		
		
	}
	
}
