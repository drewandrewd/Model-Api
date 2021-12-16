package phoenixit.education.services;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerService.class);

    public static org.slf4j.Logger getLogger() {
        return logger;
    }
}

