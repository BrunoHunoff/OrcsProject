package com.orcs.orcamentos.services;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpfValidationService {

    public boolean isValidCpf(String cpf) {
        var validator = new CPFValidator();
        List<ValidationMessage> errors = validator.invalidMessagesFor(cpf);
        return errors.isEmpty();
    }
}
