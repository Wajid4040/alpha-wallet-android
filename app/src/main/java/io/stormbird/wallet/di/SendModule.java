package io.stormbird.wallet.di;

import dagger.Module;
import dagger.Provides;
import io.stormbird.wallet.interact.ENSInteract;
import io.stormbird.wallet.repository.EthereumNetworkRepositoryType;
import io.stormbird.wallet.repository.TokenRepositoryType;
import io.stormbird.wallet.router.ConfirmationRouter;
import io.stormbird.wallet.router.MyAddressRouter;
import io.stormbird.wallet.service.GasService;
import io.stormbird.wallet.service.TokensService;
import io.stormbird.wallet.viewmodel.SendViewModelFactory;

@Module
class SendModule {
    @Provides
    SendViewModelFactory provideSendViewModelFactory(ConfirmationRouter confirmationRouter,
                                                     MyAddressRouter myAddressRouter,
                                                     ENSInteract ensInteract,
                                                     EthereumNetworkRepositoryType networkRepositoryType,
                                                     TokensService tokensService,
                                                     GasService gasService) {
        return new SendViewModelFactory(confirmationRouter,
                myAddressRouter,
                ensInteract,
                networkRepositoryType,
                tokensService,
                gasService);
    }

    @Provides
    ConfirmationRouter provideConfirmationRouter() {
        return new ConfirmationRouter();
    }

    @Provides
    MyAddressRouter provideMyAddressRouter() {
        return new MyAddressRouter();
    }

    @Provides
    ENSInteract provideENSInteract(TokenRepositoryType tokenRepository) {
        return new ENSInteract(tokenRepository);
    }
}
