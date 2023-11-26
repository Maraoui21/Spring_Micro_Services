package com.example.accountservice.command.aggregate;

import lombok.NoArgsConstructor;
import com.example.accountservice.common.commands.CreateAccountCommand;
import com.example.accountservice.common.commands.CreditAccountCommand;
import com.example.accountservice.common.commands.WithdrawAccountCommand;
import com.example.accountservice.common.enums.AccountStatus;
import com.example.accountservice.common.event.AccountCreatedEvent;
import com.example.accountservice.common.event.AccountCreditedEvent;
import com.example.accountservice.common.event.AccountWithdrawnEvent;
import com.example.accountservice.common.exception.InsufficientBalanceException;
import com.example.accountservice.common.exception.NegativeAmountException;
import com.example.accountservice.common.exception.NegativeStartingBalanceException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId;
    private String currency;
    private double balance;
    private AccountStatus status;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        if (command.getStartingBalance() < 0) {
            throw new NegativeStartingBalanceException("Starting balance cannot be negative");
        }
        AggregateLifecycle.apply(
                new AccountCreatedEvent(
                        command.getId(),
                        command.getCurrency(),
                        command.getStartingBalance(),
                        AccountStatus.CREATED
                )
        );
    }

    @CommandHandler
    public void handle(CreditAccountCommand command) {
        if (command.getAmount() < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }
        AggregateLifecycle.apply(
                new AccountCreditedEvent(
                        command.getId(),
                        command.getCurrency(),
                        command.getAmount()
                )
        );
    }

    @CommandHandler
    public void handle(WithdrawAccountCommand command) {
        if (command.getAmount() < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }
        if (this.balance - command.getAmount() < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        AggregateLifecycle.apply(
                new AccountWithdrawnEvent(
                        command.getId(),
                        command.getCurrency(),
                        command.getAmount()
                )
        );
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.accountId = event.getId();
        this.currency = event.getCurrency();
        this.balance = event.getBalance();
        this.status = event.getStatus();
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent event) {
        // TODO : add currency conversion
        this.balance += event.getAmount();
    }

    @EventSourcingHandler
    public void on(AccountWithdrawnEvent event) {
        // TODO : add currency conversion
        this.balance -= event.getAmount();
    }
}
