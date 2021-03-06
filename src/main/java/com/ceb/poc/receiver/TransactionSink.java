/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ceb.poc.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author Dave Syer
 *
 */
@EnableBinding(TranSource.class)
public class TransactionSink {

	private static Logger logger = LoggerFactory.getLogger(TransactionSink.class);

	private TranRepository tranRepository;

	@Autowired
	public TransactionSink(TranRepository tranRepository) {
		this.tranRepository = tranRepository;
	}

	@StreamListener(TranSource.BALANCE)
	public void loggerSink(@Payload Transaction payload) {
		logger.info("Received: " + payload);
		tranRepository.save(payload);
	}

}
