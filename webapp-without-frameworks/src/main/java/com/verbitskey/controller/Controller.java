package com.verbitskey.controller;

import com.verbitskey.Request;
import com.verbitskey.ViewModel;

public interface Controller {

    ViewModel process(Request req);

}

