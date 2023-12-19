package io.petstore.tests;

import io.petstore.helpers.DataGenerator;
import io.petstore.methods.Delete;
import io.petstore.methods.Get;
import io.petstore.methods.Post;

public class PageManager {

//    protected DataGenerator dataGenerator = new DataGenerator();
    protected Post post = new Post();
    protected Get get = new Get();
    protected Delete delete = new Delete();
}