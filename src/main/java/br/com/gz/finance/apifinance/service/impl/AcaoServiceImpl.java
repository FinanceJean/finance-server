package br.com.gz.finance.apifinance.service.impl;

import br.com.gz.finance.apifinance.converter.AcaoDTOConverter;
import br.com.gz.finance.apifinance.model.Acao;
import br.com.gz.finance.apifinance.model.AcaoDto;
import br.com.gz.finance.apifinance.model.Usuario;
import br.com.gz.finance.apifinance.repository.AcaoRepository;
import br.com.gz.finance.apifinance.service.AcaoService;
import br.com.gz.finance.apifinance.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AcaoServiceImpl extends CrudServiceImpl<Acao, Long>
        implements AcaoService {

    private final AcaoRepository acaoRepository;

    private final UsuarioService usuarioService;

    @Autowired
    public AcaoServiceImpl(AcaoRepository acaoRepository,
                           UsuarioService usuarioService) {
        this.acaoRepository = acaoRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    protected JpaRepository<Acao, Long> getRepository() {
        return acaoRepository;
    }

    @Override
    public Acao findAcaoBySymbol(String symbol) {
        return acaoRepository.findAcaoBySymbolEquals(symbol);
    }

    @Override
    public List<Acao> complete(String query) {
        if (query.isEmpty()) {
            PageRequest pageRequest = PageRequest.of(0, 10);
            return acaoRepository.findAll(pageRequest).getContent();
        }
        return acaoRepository.findTop10BySymbolLike("%" + query.toUpperCase() + "%");
    }

    @Override
    public List<AcaoDto> findAllAcaoByUsuario(String username) {
        Usuario user = usuarioService.findUsuarioByUsername(username);
        if (Objects.isNull(user))
            return null;

        return user.getAcoes().stream()
                .map(acao -> AcaoDTOConverter.toAcaoDto(acao))
                .collect(Collectors.toList());
    }
}
