package com.example.miniscout.shared;

import java.net.URI;

public interface IDatabaseService {

	public Form load(URI source) throws Exception;

	public void save(Form form, URI target) throws Exception;
}
